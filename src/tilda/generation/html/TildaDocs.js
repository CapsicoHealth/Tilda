var onModalCloseClicked = function(modalId)
{
  modal = document.getElementById(modalId);
  modal.style.display = "none";
  document.documentElement.style.overflow = "auto";
}

window.addEventListener("click", function(event)
{
  targetId = event.target.getAttribute("id");
  if (targetId != null && targetId.endsWith("_MODAL"))
    {
      onModalCloseClicked(targetId);
    }
});

document.onkeydown = function(evt)
{
  evt = evt || window.event;
  var isEscape = false;
  if ("key" in evt)
    {
      isEscape = (evt.key == "Escape" || evt.key == "Esc");
    }
  else
    {
      isEscape = (evt.keyCode == 27);
    }
  if (isEscape)
    {
      closeAllModals();
    }
};

function fireEvent(e, eventName)
{
  if (typeof e == 'string')
   e = this.getElement(e);
  if (e.fireEvent != null)
    e.fireEvent("on"+eventName);
  else if ("createEvent" in document)
   {
     var evt = document.createEvent("HTMLEvents");
     evt.initEvent(eventName, false, true);
     e.dispatchEvent(evt);
   }
  else
   console.log("No support to fire events.");    
};

var closeAllModals = function()
{
  var modals = document.getElementsByClassName("modal");
  for (var i = 0; i < modals.length; i++)
    {
      modals[i].style.display = 'none';
    }
  document.getElementById('__SEARCH_BOX_RESULTS__').style.display = 'none';
  document.documentElement.style.overflow = "auto";
}

var onModalShowClicked = function(id)
{
  modal = document.getElementById(id + "_MODAL");
  modal.style.display = "block";
  document.documentElement.style.overflow = "hidden";
}

window.addEventListener('load', function()
{
//  expand_buttons = document.getElementsByClassName("expand_div");
//  for (var i = 0; i < expand_buttons.length; i++)
//    {
//      expand_buttons[i].addEventListener("click", function(event)
//      {
//        if (event.target.parentElement.getElementsByTagName("div")[0].style.display == "none")
//          {
//            event.target.parentElement.getElementsByTagName("div")[0].style.display = "block"
//            event.target.innerHTML = "&#9660;"
//          }
//        else
//          {
//            event.target.parentElement.getElementsByTagName("div")[0].style.display = "none"
//            event.target.innerHTML = "&#9654;"
//          }
//      }, false);
//    }
}, false);

var tables = {};
var columns = {};
var formulae = {};
var realizedcolumns = {};
var realizedformulae = {};
var searchInput;
var searchResultsDiv;

window.addEventListener("load", function()
{
  tables = getData("tables");
  columns = getData("columns");
  formulae = getData("formulae");
  realizedcolumns = getData("realizedcolumns");
  realizedformulae = getData("realizedformulae");
}, false);


function blinkElement(e, className, millis)
 {
   if (typeof e == "string")
    e = document.getElementById(e);
   if (e != null && e.classList != null)
    {
      e.classList.add(className);
      setTimeout(function() {   
        e.classList.remove(className);
      }, millis);
    }
}

var openDiv = function(divId, yOffsetCorrection)
{
//  freezeSearchResults(true);
  var e = document.getElementById(divId);
  if (e != null)
   {
     var savedE = e;
     while (e != null && e.nodeName != 'TR' && e.nodeName != 'TABLE' && e.nodeName != 'DIV')
      e=e.parentNode;
     if (e == null)
      e = savedE;
     window.location.hash = divId;
     e.scrollIntoView(/*{block: "center"}*/);
     window.scrollBy(0, divId.endsWith("_CNT") == true ? 0 : -100);
     setTimeout(function() { 
       e.scrollIntoView(/*{block: "center"}*/);
       window.scrollBy(0, divId.endsWith("_CNT") == true ? 0 : -100);
       blinkElement(e, "blink_div", 500);
     }, 200);
   }
//  window.location = "#" + divId;
//  setTimeout(function()
//  {
//    if (yOffsetCorrection != null)
//     window.scrollBy(0, yOffsetCorrection);
//    freezeSearchResults(false);
//  }, 50);
}

function showSearchResults(show)
{
  document.getElementById('__SEARCH_BOX_RESULTS__').style.display = show ? 'inline' : 'none';
}

var SearchScrollTop = null;
function freezeSearchResults(freeze)
{
  var e = document.getElementById('__SEARCH_BOX_RESULTS__');
  if (freeze == true)
    SearchScrollTop = e.scrollTop;
  else
    e.scrollTop = SearchScrollTop;
}

var eventListener = function()
{
  if (searchInput == null || searchInput == undefined)
    {
      searchInput = document.getElementById('search_input');
    }
  if (searchResultsDiv == null || searchResultsDiv == undefined)
    {
      searchResultsDiv = document.getElementById('__SEARCH_BOX_RESULTS__');
    }
  var searchInputText = searchInput.value;
  showSearchResults(searchInputText != null && searchInputText != '');

  var filteredResults = getFilteredResults(searchInputText);
  filteredResults = sortFilteredResults(filteredResults);
  // Append Header
  var tempElementBody = "";
  if (Object.keys(filteredResults).length > 0)
    {
      tempElementBody += "<TR><th align='left'>&nbsp;Table/View</th><th align='left'>Field</th><TH>&nbsp;&nbsp;&nbsp;<A href=\"javascript:showSearchResults(false);\">X</A>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</TH></TR>";
    }
  else
    {
      tempElementBody += "<TR><td colspan=\"2\">No Results Found</td></TR>";
    }
  for (key in filteredResults)
    {
      value = filteredResults[key];
      // Add Table/View
      tempElementBody += "<TR valign=\"top\"><td width=\"1px\">&nbsp;<A href=\"javascript:openDiv('" + key + "_CNT',20)\">" + key + "</A></TD>";
      // Add Columns/Formulae (if Any)
      if (value.length == 0)
       {
         tempElementBody += "<TD>&nbsp;</TD><TD>&nbsp;</TD></TR>";
       }
      else
      for (var i = 0; i < value.length; i++)
        {
          if (i != 0)
            tempElementBody += "<TR><TD>&nbsp;</TD>";
          tempElementBody += "<TD><A href=\"javascript:openDiv('" + key + "-" + value[i] + "_DIV', -50)\">" + value[i]+ "</A></TD><TD>&nbsp;</TD></TR>";
        }
    }
  searchResultsDiv.innerHTML = tempElementBody;
}


var eventListener_master = function(event)
{
  if (searchInput == null || searchInput == undefined)
    {
      searchInput = document.getElementById('search_input');
    }
  var searchInputText = searchInput.value;
  showSearchResults(searchInputText != null && searchInputText != '');
  var regex = new RegExp(searchInputText, 'gi');

  var Str = "";
  var ps = null;
  var pt = null;
  for (var gi = 0; gi < dbMeta.length; ++gi)
    for (var si = 0; si < dbMeta[gi].schemas.length; ++si)
      {
        var s = dbMeta[gi].schemas[si];
        if (regex.test(s.name) == true)
          {
            Str += '<TR><TD colspan="3">&nbsp;<A href="javascript:MasterIndex.paintResult(\''+s.name+'\', null, null);">'+s.name+'</A></TD></TR>';
            ps=s;
          }
        for (var ti = 0; ti < s.objs.length; ++ti)
          {
            var t = s.objs[ti];
            if (regex.test(t.name) == true)
             {
               Str += '<TR><TD colspan="1">'+(ps==s?'':'&nbsp;<A href="javascript:MasterIndex.paintResult(\''+s.name+'\', null, null);">'+s.name+'</A>')+'</TD>'
                         +'<TD colspan="2">&nbsp;<A href="javascript:MasterIndex.paintResult(\''+s.name+'\', \''+t.name+'\', null);">'+t.name+'</A></TD>'
                     +'</TR>';
               ps=s;
               pt=t;
             }
            for (var ci = 0; ci < t.cols.length; ++ci)
              {
                var c = t.cols[ci];
                if (regex.test(c.name) == true)
                 {
                   Str += '<TR><TD>'+(ps==s?'':'&nbsp;<A href="javascript:MasterIndex.paintResult(\''+s.name+'\', null, null);">'+s.name+'</A>')+'</TD>'
                             +'<TD>'+(pt==t?'':'&nbsp;<A href="javascript:MasterIndex.paintResult(\''+s.name+'\', \''+t.name+'\', null);">'+t.name+'</A>')+'</TD>'
                             +'<TD>&nbsp;<A href="javascript:MasterIndex.paintResult(\''+s.name+'\', \''+t.name+'\', \''+c.name+'\');">'+c.name+'</A></TD>'
                         +'</TR>';
                   ps=s;
                   pt=t;
                 }
              }
          }
      }
  if (Str=="")
    Str += "<TR><td colspan=\"2\">No Results Found</td></TR>";
  else
    Str = "<TR><th align='left'>&nbsp;Schema</th><th align='left'>&nbsp;Table/View</th><th align='left'>Field</th><TH>&nbsp;&nbsp;&nbsp;<A href=\"javascript:showSearchResults(false);\">X</A>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</TH></TR>"+Str;

  if (searchResultsDiv == null || searchResultsDiv == undefined)
    {
      searchResultsDiv = document.getElementById('__SEARCH_BOX_RESULTS__');
    }
  searchResultsDiv.innerHTML = Str;
  event.preventDefault();
  event.stopPropagation();
}


// Helper Methods
var sortFilteredResults = function(results)
{
  var sortedResults = {};
  Object.keys(results).sort().forEach(function(key)
  {
    sortedResults[key] = results[key];
  });
  return sortedResults;
}

var getFilteredData = function(regex, sourceData, destinationData)
{
  for (key in sourceData)
    {
      var table_name = sourceData[key][0];
      var column_name = sourceData[key][1];
      if (regex.test(table_name))
        {
          if (destinationData[table_name] == undefined)
            destinationData[table_name] = [];
        }
      if (column_name != undefined && regex.test(column_name))
        {
          var existing_columns = destinationData[table_name];
          if (existing_columns == undefined)
            existing_columns = [];
          existing_columns.push(column_name);
          destinationData[table_name] = existing_columns;
        }
    }
  return destinationData;
}

function filterTable(tableId)
 {
   var e = document.getElementById(tableId);
   var realizedFilter = document.getElementById(tableId+"_R");
   var formulaFilter = document.getElementById(tableId+"_F");
   if (e == null || realizedFilter == null || formulaFilter == null)
     return;
   
   for (var i = 1; i < e.rows.length; ++i)
     {
       var r = e.rows[i];
       var isRealized = r.cells[4].innerHTML.indexOf("<!--R-->")!=-1;
       var isFormula = r.cells[5].innerHTML.indexOf("Formula column")==0;
       var showRealized = realizedFilter.checked == false || isRealized == true;
       var showFormula  = formulaFilter.checked == false || isFormula == true;
       
       r.style.visibility = showRealized && showFormula ? "visible" : "collapse";
     }
 }

var getFilteredResults = function(queryString)
{
  var regex = new RegExp(queryString, 'gi');
  var matchingResults = {};
  var doColumns = document.getElementById('cols_check').checked;
  var doFormulas = document.getElementById('formulas_check').checked;
  var doRealized = document.getElementById('realized_check').checked;

  if (doColumns == true)
    {
      console.log("columns: ", columns);
      getFilteredData(regex, tables, matchingResults);
      getFilteredData(regex, doRealized == true ? realizedcolumns : columns, matchingResults);
    }
  if (doFormulas == true)
    {
      getFilteredData(regex, doRealized == true ? realizedformulae : formulae, matchingResults);
    }
  return matchingResults;
}

var getData = function(type)
{
  var dataDivs = document.getElementsByClassName(type);
  var divIds = {};
  var tempId;
  for (var i = 0; i < dataDivs.length; i++)
    {
      tempId = dataDivs[i].getAttribute("id");
      if (tempId != undefined && tempId.length > 0)
        {
          divIds[tempId] = tempId.replace("_DIV", "").split("-");
        }
    }
  return divIds;
}



Object.extend = function(source1, source2, destination)
{
  for ( var key in source1)
    {
      destination[key] = source1[key];
    }
  for ( var key in source2)
    {
      destination[key] = source2[key];
    }
  return destination;
}

var headers = [];

function registerStickyHeader(elementId)
{
  var h = document.getElementById(elementId);
  headers.push([
      h, h.offsetTop
  ]);
}

function checkSticky()
{
  for (var i = 0; i < headers.length; ++i)
    {
      var h = headers[i];
      var pos = h[0].offsetTop;
      if (pos != 0)
        h[1] = pos;
      if (window.pageYOffset >= h[1] - 5)
        {
          h[0].classList.add("sticky");
          var n = document.getElementById('__SEARCH_BOX__');
          if (n != null && n.parentNode != null && h[0] != null && h[0] != n)
            {
              n.classList.remove("sticky");
              n.parentNode.removeChild(n);
              h[0].rows[0].cells[1].appendChild(n);
            }
        }
      else
        {
          h[0].classList.remove("sticky");
        }
      if (i == 0 && window.pageYOffset < h[1])
        {
          var n = document.getElementById('__SEARCH_BOX__');
          n.parentNode.removeChild(n);
          document.getElementById('__SEARCH_BOX_BASE__').appendChild(n);
        }
    }
}

window.onscroll = checkSticky;


function getAncestorNode(e, nodeName)
 {
   while (e != null && e.nodeName != nodeName)
     e=e.parentNode;
   return e;
 }
function unselectRow(e, styleClass)
{
  var Table = getAncestorNode(e, 'TABLE');
  for (var i = 0; i < Table.rows.length; ++i)
    Table.rows[i].classList.remove(styleClass);
}
function selectRow(e, styleClass)
 {
   unselectRow(e, styleClass);
   var TR = getAncestorNode(e, 'TR');
   if (TR != null)
    TR.classList.add(styleClass);
 }
function printDocs(type, what)
 {
   return '<fieldset><legend>'+type+': <B>'+what.name+'</B></legend>'
         +(what.docs==null?'No documentation available':what.docs)
         +'</fieldset>'
         ;
 }

var MasterIndex = {
  _baseId: null
 ,paintSchemas: function(dbMeta, regex)
   {
     var Str = '<INPUT type="text" id="FILTER_SCHEMAS" placeholder="filter schemas" onkeyup="MasterIndex.filter(event, \'S\')"><TABLE class="Rowed Selectable" onClick="MasterIndex.paintObjects(event)" border=\"0px\" cellspacing=\"0px\" cellpadding=\"3px\">\n';
     for (var i = 0; i < dbMeta.length; ++i)
       {
         var g = dbMeta[i];
         Str+='<TR class="NoSelection"><TD colspan="2"><B>'+g.name+'</B></TD></TR>\n';
         for (var j = 0; j < g.schemas.length; ++j)
           Str+='<TR '+(g.schemas[j].explicit==true?'':'title="Dependency"')+'><TD style="padding-left: 25px;">'+g.schemas[j].name+'</TD><TD>'+(g.schemas[j].explicit==true?'':'<SUP class="Dependency">*</SUP>')+'</TR>\n';
       }
     Str+='</TABLE><BR><BR>\n';
     document.getElementById(this._baseId+'_SCHEMAS').innerHTML=Str;
   }

 ,selectedSchema: null
 ,selectedObject: null
 ,paintObjects: function(event)
   {
     var selected = event.target.innerText;
     var found = false;
     for (var i = 0; i < dbMeta.length; ++i)
      for (var j = 0; j < dbMeta[i].schemas.length; ++j)
       if (dbMeta[i].schemas[j].name == selected)
        {
          this.selectedGroup = dbMeta[i];
          this.selectedSchema = dbMeta[i].schemas[j];
          found = true;
          break;
        }
     if (found == false)
       {
         console.log("unknown selected schema '"+selected+"'.");
         return;
       }

     selectRow(event.target, "Selected");
     var Str = '<INPUT type="text" id="FILTER_OBJECTS" placeholder="filter Tables/Views" onkeyup="MasterIndex.filter(event, \'O\')"><TABLE class="Rowed Selectable offScreenOpacity0" onClick="MasterIndex.paintColumns(event)" border=\"0px\" cellspacing=\"0px\" cellpadding=\"3px\">\n';
     this.selectedObject = null; 
     if (this.selectedSchema.objs == null || this.selectedSchema.objs.length == 0)
       {
         Str+="<TR><TD>NO OBJECTS DEFINED</TD></TR>";
       }
     else for (var i = 0; i < this.selectedSchema.objs.length; ++i)
      {
        var o = this.selectedSchema.objs[i];
        Str+='<TR><TD>'+o.name+'</TD></TR>\n';
      }
     Str+='</TABLE><BR><BR>';
     var e = document.getElementById(this._baseId+'_OBJECTS');
     e.innerHTML=Str;
     setTimeout(function() { e.childNodes[1].classList.add("fadeInSlideTo0"); }, 10);

     document.getElementById(this._baseId+'_COLUMNS').innerHTML='';
     this.selectedColumn=null;
     this.selectedObject=null;

     var d = document.getElementById(this._baseId+'_DOCS');
     d.innerHTML=printDocs('Group', this.selectedGroup)+printDocs('Schema', this.selectedSchema);
//     setTimeout(function() { e.classList.add("fadeInSlideTo0"); }, 10);     
   }

 ,paintColumns: function(event)
   {
     var selected = event.target.innerText;
     selectRow(event.target, "Selected");
     for (var i = 0; i < this.selectedSchema.objs.length; ++i)
       if (this.selectedSchema.objs[i].name == selected)
         {
           this.selectedObject = this.selectedSchema.objs[i];
           break;
         }
     if (this.selectedObject == null)
       {
         console.log("unknown selected object '"+selected+"'.");
         return;
       }

     var Str = '<INPUT type="text" id="FILTER_COLUMNS" placeholder="filter columns" onkeyup="MasterIndex.filter(event, \'C\')"><TABLE class="Rowed offScreenOpacity0 Selectable" onClick="MasterIndex.selectColumn(event)" border=\"0px\" cellspacing=\"0px\" cellpadding=\"3px\">\n';
     if (this.selectedObject.cols == null || this.selectedObject.cols.length == 0)
       {
         Str+="<TR><TD>NO COLUMNS DEFINED</TD></TR>";
       }
     else for (var i = 0; i < this.selectedObject.cols.length; ++i)
       {
         var c = this.selectedObject.cols[i];
         Str+='<TR><TD><A href="'+c.url+'" target="_other">'+c.name+'</A></TD><TD>'+c.type+'</TD></TR>\n';
       }
     Str+='</TABLE><BR><BR>';
     var e = document.getElementById(this._baseId+'_COLUMNS');
     e.innerHTML=Str;
     setTimeout(function() { e.childNodes[1].classList.add("fadeInSlideTo0"); }, 10);
     
     var d = document.getElementById(this._baseId+'_DOCS');
     d.innerHTML=printDocs('Group', this.selectedGroup)+printDocs('Schema', this.selectedSchema)+printDocs('Object', this.selectedObject);
   }
 ,selectColumn: function(event)
   {
     selectRow(event.target, "Selected");
     var e = getAncestorNode(event.target, 'TR');
     if (e == null)
       return;
     selected = e.cells[0].innerText;
     for (var i = 0; i < this.selectedObject.cols.length; ++i)
       if (this.selectedObject.cols[i].name == selected)
         {
           this.selectedColumn = this.selectedObject.cols[i];
           break;
         }
     if (this.selectedColumn == null)
       {
         console.log("unknown selected column '"+selected+"'.");
         return;
       }

     var d = document.getElementById(this._baseId+'_DOCS');
     d.innerHTML=printDocs('Group', this.selectedGroup)+printDocs('Schema', this.selectedSchema)+printDocs('Object', this.selectedObject)+printDocs(this.selectedColumn.formula==true?'Formula':'Column', this.selectedColumn);
   }
 ,paintResult: function(schemaName, tableName, columnName)
   {
     showSearchResults(false);
     
     if (this.selectedSchema == null || this.selectedSchema.name != schemaName)
       {
         var e = document.getElementById(this._baseId+'_SCHEMAS');
         if (e != null && e.childNodes != null && e.childNodes[1] != null && e.childNodes[1].rows != null)
          {
            e = e.childNodes[1];
            for (var i = 0; i < e.rows.length; ++i)
             if (e.rows[i].cells[0].innerText==schemaName)
              {
                var cell = e.rows[i].cells[0];
                MasterIndex.paintObjects({target: cell});
                cell.scrollIntoView();
                break;
              }
          }
       }
     
     if (tableName != null && (this.selectedObject == null || this.selectedObject.name != tableName))
       {
         e = document.getElementById(this._baseId+'_OBJECTS');
         if (e != null && e.childNodes != null && e.childNodes[1] != null && e.childNodes[1].rows != null)
           {
             e = e.childNodes[1];
             for (var i = 0; i < e.rows.length; ++i)
               if (e.rows[i].innerText==tableName)
                {
                  var cell = e.rows[i].cells[0];
                  MasterIndex.paintColumns({target: cell});
                  cell.scrollIntoView();
                  break;
                }
           }
       }
     else if (tableName == null && this.selectedObject != null)
       {
         unselectRow(document.getElementById(this._baseId+'_OBJECTS').childNodes[1], 'Selected');
         document.getElementById(this._baseId+'_COLUMNS').innerHTML='';
         this.selectedObject=null;
       }

     if (columnName != null && (this.selectedColumn == null || this.selectedColumn.name != columnName))
       {
         e = document.getElementById(this._baseId+'_COLUMNS');
         if (e != null && e.childNodes != null && e.childNodes[1] != null && e.childNodes[1].rows != null)
           {
             e = e.childNodes[1];
             for (var i = 0; i < e.rows.length; ++i)
               if (e.rows[i].cells[0].innerText==columnName)
                {
                  var cell = e.rows[i].cells[0];
                  MasterIndex.selectColumn({target: cell});
                  cell.scrollIntoView(/*{block: "center"}*/);
//                  window.scrollBy(0, -100);
                  break;
                }
           }
       }
     else if (columnName == null && this.selectedColumn != null)
       {
         unselectRow(document.getElementById(this._baseId+'_COLUMNS').childNodes[1], 'Selected');
         this.selectedColumn = null;
       }
    }
  ,filter: function(event, type)
    {
      var mark = type=='S'?'_SCHEMAS':type=='O'?'_OBJECTS':'_COLUMNS';
      var val = document.getElementById('FILTER'+mark).value.toLowerCase();
      var e = document.getElementById(this._baseId+mark);
      if (e != null && e.childNodes != null && e.childNodes[1] != null && e.childNodes[1].rows != null)
        {
          e = e.childNodes[1];
          for (var i = 0; i < e.rows.length; ++i)
            if (e.rows[i].innerText.toLowerCase().indexOf(val) == -1)
              e.rows[i].style.display="none";
            else
              e.rows[i].style.display="";
        }
      event.preventDefault();
      event.stopPropagation();
    }
  ,keyup: function(event)
    {
      switch(event.which)
       {
         case 37: // left
              if (this.selectedColumn != null)
                {
                  this.paintResult(this.selectedSchema.name, this.selectedObject.name, null);
                  break
                }
              else if (this.selectedObject != null)
                {
                  this.paintResult(this.selectedSchema.name, null, null);
                  break
                }
              return;
         case 38: // up
               if (this.selectedColumn != null)
                 {
                   var i = this.selectedObject.cols.indexOf(this.selectedColumn);
                   if (i > 0)
                    {
                      this.paintResult(this.selectedSchema.name, this.selectedObject.name, this.selectedObject.cols[i-1].name);
                      break
                    }
                 }
               else if (this.selectedObject != null)
                 {
                   var i = this.selectedSchema.objs.indexOf(this.selectedObject);
                   if (i > 0)
                    {
                      this.paintResult(this.selectedSchema.name, this.selectedSchema.objs[i-1].name, null);
                      break
                    }
                 }
               else if (this.selectedSchema != null)
                 {
                   var i = dbMeta.indexOf(this.selectedSchema);
                   if (i > 0)
                    {
                      this.paintResult(dbMeta[i-1].name, null, null);
                      break
                    }
                 }
              return;
         case 39: // right
              if (this.selectedColumn != null)
               ;
              else if (this.selectedObject != null)
                {
                  this.paintResult(this.selectedSchema.name, this.selectedObject.name, this.selectedObject.cols[0].name);
                  break
                }
              else if (this.selectedSchema != null)
                {
                  this.paintResult(this.selectedSchema.name, this.selectedSchema.objs[0].name, null);
                  break
                }
              return;
         case 40: // down
              if (this.selectedColumn != null)
                {
                  var i = this.selectedObject.cols.indexOf(this.selectedColumn);
                  if (i != -1 && i < this.selectedObject.cols.length-1)
                   {
                     this.paintResult(this.selectedSchema.name, this.selectedObject.name, this.selectedObject.cols[i+1].name);
                     break
                   }
                }
              else if (this.selectedObject != null)
                {
                  var i = this.selectedSchema.objs.indexOf(this.selectedObject);
                  if (i != -1 && i < this.selectedSchema.objs.length-1)
                   {
                     this.paintResult(this.selectedSchema.name, this.selectedSchema.objs[i+1].name, null);
                     break
                   }
                }
              else if (this.selectedSchema != null)
                {
                  var i = dbMeta.indexOf(this.selectedSchema);
                  if (i != -1 && i < dbMeta.length-1)
                   {
                     this.paintResult(dbMeta[i+1].name, null, null);
                     break
                   }
                }
              return;
         default: return;
       }
      event.stopPropagation();
      event.preventDefault(); 
   }
};




