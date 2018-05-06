
var onModalCloseClicked = function(modalId) {
    modal = document.getElementById(modalId);
    modal.style.display = "none";
    document.documentElement.style.overflow = "auto"; 
  }

window.addEventListener("click", function(event) { 
    targetId = event.target.getAttribute("id"); 
    if (targetId != null && targetId.endsWith("_MODAL")){ 
      onModalCloseClicked(targetId); 
    } 
  }); 

document.onkeydown = function(evt) { 
      evt = evt || window.event; 
      var isEscape = false; 
      if ("key" in evt) { 
        isEscape = (evt.key == "Escape" || evt.key == "Esc"); 
      } else { 
        isEscape = (evt.keyCode == 27); 
      } 
      if (isEscape) { 
        closeAllModals(); 
      } 
    }; 

var closeAllModals = function() { 
    var modals = document.getElementsByClassName("modal"); 
    for(var i = 0; i < modals.length; i++) {
      modals[i].style.display = 'none'; 
    } 
    document.getElementById('__SEARCH_BOX_RESULTS__').style.display = 'none';
    document.documentElement.style.overflow = "auto"; 
  } 
  
var onModalShowClicked = function(id) {
    modal = document.getElementById(id+"_MODAL");
    modal.style.display = "block";
    document.documentElement.style.overflow = "hidden"; 
  }
  
window.addEventListener('load', function() { 
    expand_buttons = document.getElementsByClassName("expand_div"); 
    for ( var i = 0; i < expand_buttons.length; i++ ) { 
      expand_buttons[i].addEventListener("click", function(event) { 
        if ( event.target.parentElement.getElementsByTagName("div")[0].style.display == "none" ) {
           event.target.parentElement.getElementsByTagName("div")[0].style.display = "block" 
           event.target.innerHTML = "&#9660;" 
        } else { 
           event.target.parentElement.getElementsByTagName("div")[0].style.display = "none" 
           event.target.innerHTML = "&#9654;" 
        } 
      }, false); 
    } 
  }, false);

var tables    = {}; 
var columns   = {}; 
var formulae  = {}; 
var realizedcolumns  = {}; 
var realizedformulae  = {}; 
var searchInput; 
var searchResultsDiv; 

window.addEventListener("load", function() { 
    tables = getData("tables"); 
    columns = getData("columns"); 
    formulae = getData("formulae"); 
    realizedcolumns = getData("realizedcolumns"); 
    realizedformulae = getData("realizedformulae"); 
  }, false); 

var openDiv = function(divId) {
      freezeSearchResults(true);
      window.location = "#" + divId; 
      setTimeout(function() { freezeSearchResults(false);}, 50); 
  } 

function showSearchResults(show) {
    document.getElementById('__SEARCH_BOX_RESULTS__').style.display = show ? 'inline' : 'none';
  }

var SearchScrollTop = null;
function freezeSearchResults(freeze) {
    var e = document.getElementById('__SEARCH_BOX_RESULTS__');
    if (freeze == true) SearchScrollTop = e.scrollTop; else e.scrollTop = SearchScrollTop;
  }

var eventListener = function(event) { 
    if ( searchInput == null || searchInput == undefined ) { 
      searchInput = document.getElementById('search_input'); 
    } 
    if ( searchResultsDiv == null || searchResultsDiv == undefined ) { 
      searchResultsDiv = document.getElementById('__SEARCH_BOX_RESULTS__'); 
    } 
    var searchInputText = searchInput.value; 
    showSearchResults(searchInputText != null && searchInputText != '');

    var filteredResults = getFilteredResults(searchInputText); 
    filteredResults = sortFilteredResults(filteredResults); 
    // Append Header
    var tempElementBody = ""; 
    if (Object.keys(filteredResults).length > 0) { 
      tempElementBody+= "<TR><th align='left'>&nbsp;Table/View</th><th align='left'>Field</th><TH>&nbsp;&nbsp;&nbsp;<A href=\"javascript:showSearchResults(false);\">X</A>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</TH></TR>"; 
    } else { 
      tempElementBody+= "<TR><td colspan=\"2\">No Results Found</td></TR>";
    } 
    for (key in filteredResults) { 
      value = filteredResults[key]; 
      // Add Table/View
      tempElementBody += "<TR valign=\"top\"><td width=\"1px\">&nbsp;<A href=\"javascript:openDiv('"+key+"_CNT')\">"+key+"</A></TD>";
      // Add Columns/Formulae (if Any)
      for(var i = 0; i < value.length; i++) { 
          if (i!=0) tempElementBody += "<TR><TD></TD>";
          tempElementBody += "<TD><A href=\"javascript:openDiv('"+key+"-"+value[i]+"_DIV')\">"+value[i]+"</A></TD><TD>&nbsp;</TD></TR>"; 
      } 
    }
   searchResultsDiv.innerHTML = tempElementBody; 
  } 

// Helper Methods
var sortFilteredResults = function(results) { 
    var sortedResults = {}; 
    Object.keys(results).sort().forEach(function(key) { 
      sortedResults[key] = results[key]; 
    }); 
    return sortedResults; 
  } 

var getFilteredData = function(regex, sourceData, destinationData) { 
    for (key in sourceData) { 
      var table_name = sourceData[key][0]; 
      var column_name = sourceData[key][1]; 
      if (regex.test(table_name)) { 
        if( destinationData[table_name] == undefined) 
          destinationData[table_name] = []; 
      } 
      if (column_name != undefined && regex.test(column_name)) { 
        var existing_columns = destinationData[table_name]; 
        if ( existing_columns == undefined) existing_columns = []; 
        existing_columns.push(column_name); 
        destinationData[table_name] = existing_columns; 
      } 
    } 
    return destinationData; 
  } 

var getFilteredResults = function(queryString) { 
    var regex = new RegExp(queryString, 'gi'); 
    var matchingResults = {}; 
    var doColumns  = document.getElementById('cols_check').checked;
    var doFormulas = document.getElementById('formulas_check').checked;
    var doRealized = document.getElementById('realized_check').checked;
    if (doColumns == true) 
     {
       getFilteredData(regex, tables, matchingResults); 
       getFilteredData(regex, doRealized == true ? realizedcolumns : columns, matchingResults); 
     }
    if (doFormulas == true) 
     {
       getFilteredData(regex, doRealized == true ? realizedformulae : formulae, matchingResults); 
     }
    return matchingResults; 
  } 

var getData = function(type) { 
    var dataDivs = document.getElementsByClassName(type); 
    var divIds = {}; 
    var tempId; 
    for(var i = 0; i < dataDivs.length; i++) { 
      tempId = dataDivs[i].getAttribute("id"); 
      if ( tempId != undefined && tempId.length > 0) { 
        divIds[tempId] = tempId.replace("_DIV", "").split("-"); 
      } 
    } 
    return divIds; 
  } 

Object.extend = function(source1, source2, destination) { 
    for (var key in source1) { 
      destination[key] = source1[key]; 
    } 
    for (var key in source2) { 
      destination[key] = source2[key]; 
    } 
    return destination; 
  } 

var headers = [];

function registerStickyHeader(elementId) {
  var h = document.getElementById(elementId);
  headers.push([h,h.offsetTop]);
}

function checkSticky() {
for (var i = 0; i < headers.length; ++i)
 {
   var h = headers[i];
   var pos = h[0].offsetTop;
   if (pos != 0)
    h[1] = pos;
   if (window.pageYOffset >= h[1]-5)
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
