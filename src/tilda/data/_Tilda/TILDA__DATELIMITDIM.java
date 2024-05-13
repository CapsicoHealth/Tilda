/*
 Tilda V2.5 data object.

 Code is generated: do not modify! Instead, create a derived class and override desired functionality
*/

package tilda.data._Tilda;

import java.time.*;
import java.sql.Timestamp;
import java.util.*;

import tilda.db.*;
import tilda.enums.*;
import tilda.performance.*;
import tilda.utils.*;

import org.apache.logging.log4j.*;

import com.google.gson.*;
import com.google.gson.annotations.*;
import java.math.*;


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
<TABLE id="DateLimitDim_DIV" class="tables">
<SCRIPT>registerStickyHeader("DateLimitDim_DIV");</SCRIPT>
<TR valign="top"><TD><H2>DateLimitDim&nbsp;&nbsp;&nbsp;&nbsp;<SUP style="font-size: 70%;"><SPAN class="BackToDetails"><A href="#DateLimitDim_CNT">details</A>&nbsp;&nbsp;&nbsp;&nbsp;</SPAN><A href="#">top</A></SUP></H2></TD><TD align="right"></TD></TR>
</TABLE>
<DIV id="DateLimitDim_CNT" class="content">
The Table TILDA.DateLimitDim :<UL>
<LI>Is mapped to the generated Java 8/PostgreSQL Tilda classes <B>DateLimitDim_Factory</B>, <B>DateLimitDim_Data</B> in the package <B>tilda.data</B>.
<LI>Is configured for normal <B>read/write</B> access.</LI>
<LI>Is not OCC-Enabled. No record lifecycle columns (created/updated/deleted) have been generated.</LI>
<LI>Defines 3 foreign key(s):<BR>
<TABLE style="margin-left: 25px; border:1px solid #BBB;" cellspacing="0px" cellpadding="5px" border="0px">
<TR style="background-color:#DDD; font-weight:bold;"><TD></TD><TD>Source Columns</TD><TD>Destination Object</TD><TD>Destination Columns</TD><TD>Notes</TD></TR>
<TR ><TD>1</TD><TD>invalidDate</TD><TD><A href="TILDA___Docs.TILDA.html#DateDim_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>DateDim</A></TD><TD>dt</TD><TD>&nbsp;</TD></TR>
</TABLE></LI>
<LI>Has the following identity:<UL><LI>Unique Index: invalidDate</LI>
</UL></LI>
</UL>
<B>Description</B>:<BLOCKQUOTE style="border-left: 1px solid #EEE;padding-left: 5px;">A single row for min, max and invalid dates for the Date_Dim</BLOCKQUOTE>
<BR>
This Table contains the following columns:<BLOCKQUOTE>
 <TABLE id="DateLimitDim_TBL" border="0px" cellpadding="3px" cellspacing="0px" style="border:1px solid #BBB;">
   <TR valign="bottom"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH align="left">Type</TH><TH align="left">Nullable</TH><TH align="left">Mode</TH><TH align="left">Invariant</TH><TH align="left">Protect</TH><TH align="left">Description</TH></TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>1&nbsp;&nbsp;</TD>
<TD align="right"><B id='DateLimitDim-invalidDate_DIV' class='columns'>invalidDate</B>&nbsp;&nbsp;</TD>
<TD>LocalDate&nbsp;/&nbsp;date&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The invalid date, e.g., '1111-11-11'.<TABLE border="0px" style="margin:0px;margin-left:20px;font-size:75%;"><TR><TD><B style="color:white;background-color:fuchsia;">FK</B></TD><TD>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#DateDim_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>DateDim</A>: dt</TD></TR>
</TABLE>
</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>2&nbsp;&nbsp;</TD>
<TD align="right"><B id='DateLimitDim-minDate_DIV' class='columns'>minDate</B>&nbsp;&nbsp;</TD>
<TD>LocalDate&nbsp;/&nbsp;date&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The min date included in the DIM<TABLE border="0px" style="margin:0px;margin-left:20px;font-size:75%;"><TR><TD><B style="color:white;background-color:fuchsia;">FK</B></TD><TD>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#DateDim_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>DateDim</A>: dt</TD></TR>
</TABLE>
</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>3&nbsp;&nbsp;</TD>
<TD align="right"><B id='DateLimitDim-maxDate_DIV' class='columns'>maxDate</B>&nbsp;&nbsp;</TD>
<TD>LocalDate&nbsp;/&nbsp;date&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The max date included in the DIM<TABLE border="0px" style="margin:0px;margin-left:20px;font-size:75%;"><TR><TD><B style="color:white;background-color:fuchsia;">FK</B></TD><TD>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#DateDim_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>DateDim</A>: dt</TD></TR>
</TABLE>
</TD>
</TR>
</TABLE></BLOCKQUOTE>
</DIV>

*/
@SuppressWarnings({ "unused" })
public abstract class TILDA__DATELIMITDIM implements tilda.interfaces.WriterObject, tilda.interfaces.JSONable, tilda.interfaces.CSVable
 {
   protected transient static final Logger LOG = LogManager.getLogger(TILDA__DATELIMITDIM.class.getName());

   public transient static final Class<TILDA__DATELIMITDIM_Factory> FACTORY_CLASS= TILDA__DATELIMITDIM_Factory.class;
   public transient static final String TABLENAME = TextUtil.print("TILDA.DateLimitDim", "");

   protected TILDA__DATELIMITDIM() { }

   transient InitMode __Init        = null;
   transient BitSet   __Nulls       = new BitSet(64);
   transient BitSet   __Changes     = new BitSet(64);
   transient boolean  __NewlyCreated= false;
   transient int      __LookupId;

   public  boolean hasChanged    () { return __Changes.isEmpty() == false; }
   public  boolean isNewlyCreated() { return __NewlyCreated; }

   void initForCreate()
     {
       __Init         = InitMode.CREATE;
       __NewlyCreated = true ;
       __LookupId     = SystemValues.EVIL_VALUE;
     }
   void initForLookup(int LookupId)
     {
       __Init     = InitMode.LOOKUP;
       __LookupId = LookupId       ;
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateLimitDim.invalidDate -> TILDA.DateLimitDim."invalidDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>invalidDate of type LocalDate</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The invalid date, e.g., '1111-11-11'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateLimitDim.invalidDate of type date</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateLimitDim.invalidDate</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("invalidDate")
   LocalDate _invalidDate=null;
   protected LocalDate __Saved_invalidDate;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateLimitDim.invalidDate -> TILDA.DateLimitDim."invalidDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>invalidDate of type LocalDate</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The invalid date, e.g., '1111-11-11'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateLimitDim.invalidDate of type date</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateLimitDim.invalidDate</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final LocalDate getInvalidDate()
      { return _invalidDate; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateLimitDim.invalidDate -> TILDA.DateLimitDim."invalidDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>invalidDate of type LocalDate</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The invalid date, e.g., '1111-11-11'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateLimitDim.invalidDate of type date</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateLimitDim.invalidDate</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setInvalidDate(LocalDate v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.DateLimitDim.invalidDate to null: it's not nullable.");
       else if (v.equals(_invalidDate) == false)
        {
          __Changes.or(TILDA__DATELIMITDIM_Factory.COLS.INVALIDDATE._Mask);
          __Nulls.andNot(TILDA__DATELIMITDIM_Factory.COLS.INVALIDDATE._Mask);
       _invalidDate = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateLimitDim.invalidDate -> TILDA.DateLimitDim."invalidDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>invalidDate of type LocalDate</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The invalid date, e.g., '1111-11-11'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateLimitDim.invalidDate of type date</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateLimitDim.invalidDate</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedInvalidDate()
     { return __Changes.intersects(TILDA__DATELIMITDIM_Factory.COLS.INVALIDDATE._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateLimitDim.minDate -> TILDA.DateLimitDim."minDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>minDate of type LocalDate</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The min date included in the DIM</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateLimitDim.minDate of type date</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateLimitDim.minDate</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("minDate")
   LocalDate _minDate=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateLimitDim.minDate -> TILDA.DateLimitDim."minDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>minDate of type LocalDate</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The min date included in the DIM</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateLimitDim.minDate of type date</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateLimitDim.minDate</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final LocalDate getMinDate()
      { return _minDate; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateLimitDim.minDate -> TILDA.DateLimitDim."minDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>minDate of type LocalDate</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The min date included in the DIM</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateLimitDim.minDate of type date</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateLimitDim.minDate</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setMinDate(LocalDate v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.DateLimitDim.minDate to null: it's not nullable.");
       else if (v.equals(_minDate) == false)
        {
          __Changes.or(TILDA__DATELIMITDIM_Factory.COLS.MINDATE._Mask);
          __Nulls.andNot(TILDA__DATELIMITDIM_Factory.COLS.MINDATE._Mask);
       _minDate = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateLimitDim.minDate -> TILDA.DateLimitDim."minDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>minDate of type LocalDate</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The min date included in the DIM</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateLimitDim.minDate of type date</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateLimitDim.minDate</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedMinDate()
     { return __Changes.intersects(TILDA__DATELIMITDIM_Factory.COLS.MINDATE._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateLimitDim.maxDate -> TILDA.DateLimitDim."maxDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>maxDate of type LocalDate</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The max date included in the DIM</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateLimitDim.maxDate of type date</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateLimitDim.maxDate</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("maxDate")
   LocalDate _maxDate=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateLimitDim.maxDate -> TILDA.DateLimitDim."maxDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>maxDate of type LocalDate</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The max date included in the DIM</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateLimitDim.maxDate of type date</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateLimitDim.maxDate</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final LocalDate getMaxDate()
      { return _maxDate; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateLimitDim.maxDate -> TILDA.DateLimitDim."maxDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>maxDate of type LocalDate</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The max date included in the DIM</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateLimitDim.maxDate of type date</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateLimitDim.maxDate</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setMaxDate(LocalDate v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.DateLimitDim.maxDate to null: it's not nullable.");
       else if (v.equals(_maxDate) == false)
        {
          __Changes.or(TILDA__DATELIMITDIM_Factory.COLS.MAXDATE._Mask);
          __Nulls.andNot(TILDA__DATELIMITDIM_Factory.COLS.MAXDATE._Mask);
       _maxDate = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateLimitDim.maxDate -> TILDA.DateLimitDim."maxDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>maxDate of type LocalDate</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The max date included in the DIM</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateLimitDim.maxDate of type date</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateLimitDim.maxDate</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedMaxDate()
     { return __Changes.intersects(TILDA__DATELIMITDIM_Factory.COLS.MAXDATE._Mask); }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 Copies all the field which are not part of the primary key, not are CALCULATED and not invariant, from the 
 current object to the destination. 
*/
   public void copyTo(tilda.data._Tilda.TILDA__DATELIMITDIM Dst) throws Exception
     {
       if (_invalidDate != null)
        Dst.setInvalidDate(_invalidDate);
       if (_minDate     != null)
        Dst.setMinDate    (_minDate    );
       if (_maxDate     != null)
        Dst.setMaxDate    (_maxDate    );
     }


   public tilda.data.DateLimitDim_Data copy() throws Exception
     {
       tilda.data.DateLimitDim_Data dst = new tilda.data.DateLimitDim_Data();
       copyTo(dst);
       return dst;
     }

/**
 Sets the 'lastUpdated' column to now and causes a Write to occur to update the object in the data store.
*/
   public abstract boolean touch(Connection C) throws Exception;

/**
 Writes the object to the data store if any changes has occurred since the object was initially
 read from the data store or last written. 
 If the object was deserialized (i.e., not created via the factory lookup() or create() methods, 
 then this method assumes a create() and will check that all non-null columns have been provided. If you 
 need more flexibility for an upsert, use the upsert(Connection, boolean) version of write 
 which will try a combination of insert/update to get the object to the DB. 
 Note that if you use write() right after a create, lookup or deserialization initialization, only the
 template fields (not null, natural identity and/or any field set prior to calling this method) exist 
  in memory. Call refresh() to force a select and retrieve all the fields for that record.
*/
   public final boolean write(Connection C) throws Exception
     {
       long T0 = System.nanoTime();

       if (__Init == null && __LookupId==0) // Loaded via some other mechamism, e.g., Json or CSV loader
        {
          validateDeserialization();
          initForCreate();
        }

       if (hasChanged() == false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.data.TILDA.DateLimitDim has not changed: no writing will occur.");
          QueryDetails.setLastQuery(TILDA__DATELIMITDIM_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }

       if (beforeWrite(C) == false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.data.TILDA.DateLimitDim object's beforeWrite() failed.");
          QueryDetails.setLastQuery(TILDA__DATELIMITDIM_Factory.SCHEMA_TABLENAME_LABEL, "");
          return false;
        }

       String Q = getWriteQuery(C);

       java.sql.PreparedStatement PS = null;
       int count = 0;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
       try
        {
          PS = C.prepareStatement(Q);
          int i = populatePreparedStatement(C, PS, AllocatedArrays);

          switch (__LookupId)
           {
             case 0: // Unique Index 'InvalidDate'
               PS.setDate(++i, new java.sql.Date(_invalidDate.getYear()-1900, _invalidDate.getMonthValue()-1, _invalidDate.getDayOfMonth()));
               break;
             case -666: if (__Init == InitMode.CREATE) break;
             default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot prepare statement.");
           }

          C.setSavepoint();
          count = PS.executeUpdate();
          C.releaseSavepoint(true);
          if (count == 0)
           return false;
        }
       catch (java.sql.SQLException E)
        {
          C.releaseSavepoint(false);
          return C.handleCatch(E, "updated or inserted");
        }
       finally
        {
          tilda.data._Tilda.TILDA__2_5.handleFinally(PS, T0, TILDA__DATELIMITDIM_Factory.SCHEMA_TABLENAME_LABEL, __Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, null);
          PS = null;
        }

       stateUpdatePostWrite();
       return true;
     }

   protected abstract boolean beforeWrite(Connection C) throws Exception;

   protected void validateDeserialization() throws Exception
     {

       if (_invalidDate == null)
        throw new Exception("Incoming value for 'tilda.data.TILDA.DateLimitDim.invalidDate' was null or empty. It's not nullable in the model.\n"+toString());
          __Changes.or(TILDA__DATELIMITDIM_Factory.COLS.INVALIDDATE._Mask);
          __Nulls.andNot(TILDA__DATELIMITDIM_Factory.COLS.INVALIDDATE._Mask);

       if (_minDate == null)
        throw new Exception("Incoming value for 'tilda.data.TILDA.DateLimitDim.minDate' was null or empty. It's not nullable in the model.\n"+toString());
          __Changes.or(TILDA__DATELIMITDIM_Factory.COLS.MINDATE._Mask);
          __Nulls.andNot(TILDA__DATELIMITDIM_Factory.COLS.MINDATE._Mask);

       if (_maxDate == null)
        throw new Exception("Incoming value for 'tilda.data.TILDA.DateLimitDim.maxDate' was null or empty. It's not nullable in the model.\n"+toString());
          __Changes.or(TILDA__DATELIMITDIM_Factory.COLS.MAXDATE._Mask);
          __Nulls.andNot(TILDA__DATELIMITDIM_Factory.COLS.MAXDATE._Mask);
     }
   protected String getTimeStampSignature() throws Exception
     {
       StringBuilder S = new StringBuilder(1024);
       return S.toString();
     }
   protected String getWriteQuery(Connection C) throws Exception
     {
       StringBuilder S = new StringBuilder(1024);

       if (__Init == InitMode.CREATE)
        {
          StringBuilder V = new StringBuilder(1024);
          S.append("insert into "); C.getFullTableVar(S, "TILDA", "DateLimitDim");
          int Pos = S.length();
          if (__Changes.intersects(TILDA__DATELIMITDIM_Factory.COLS.INVALIDDATE._Mask) == true) { TILDA__DATELIMITDIM_Factory.COLS.INVALIDDATE.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__DATELIMITDIM_Factory.COLS.INVALIDDATE._Mask) == false && DateTimeUtil.isNowPlaceholder(_invalidDate) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);
           }
          if (__Changes.intersects(TILDA__DATELIMITDIM_Factory.COLS.MINDATE._Mask) == true) { TILDA__DATELIMITDIM_Factory.COLS.MINDATE.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__DATELIMITDIM_Factory.COLS.MINDATE._Mask) == false && DateTimeUtil.isNowPlaceholder(_minDate) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);
           }
          if (__Changes.intersects(TILDA__DATELIMITDIM_Factory.COLS.MAXDATE._Mask) == true) { TILDA__DATELIMITDIM_Factory.COLS.MAXDATE.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__DATELIMITDIM_Factory.COLS.MAXDATE._Mask) == false && DateTimeUtil.isNowPlaceholder(_maxDate) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);
           }

          S.setCharAt(Pos, '(');
          V.setCharAt(0, '(');
          S.append(") values ").append(V).append(')');
          V.setLength(0);
          V = null;
        }
       else // InitMode can be anything else
        {
          S.append("update "); C.getFullTableVar(S, "TILDA", "DateLimitDim"); S.append(" set");
          int Pos = S.length();
          if (__Changes.intersects(TILDA__DATELIMITDIM_Factory.COLS.INVALIDDATE._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__DATELIMITDIM_Factory.COLS.INVALIDDATE._Mask) == false && DateTimeUtil.isNowPlaceholder(_invalidDate) == true)
              { TILDA__DATELIMITDIM_Factory.COLS.INVALIDDATE.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__DATELIMITDIM_Factory.COLS.INVALIDDATE.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__DATELIMITDIM_Factory.COLS.MINDATE._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__DATELIMITDIM_Factory.COLS.MINDATE._Mask) == false && DateTimeUtil.isNowPlaceholder(_minDate) == true)
              { TILDA__DATELIMITDIM_Factory.COLS.MINDATE.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__DATELIMITDIM_Factory.COLS.MINDATE.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__DATELIMITDIM_Factory.COLS.MAXDATE._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__DATELIMITDIM_Factory.COLS.MAXDATE._Mask) == false && DateTimeUtil.isNowPlaceholder(_maxDate) == true)
              { TILDA__DATELIMITDIM_Factory.COLS.MAXDATE.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__DATELIMITDIM_Factory.COLS.MAXDATE.getFullColumnVarForUpdate(C, S);
           }

          switch (__LookupId)
           {
             case 0: // Unique Index 'InvalidDate'
                S.append(" where ("); C.getFullColumnVar(S, "TILDA", "DateLimitDim", "invalidDate"); S.append("=?");  S.append(")");
                break;
             case -77: 
             case -666: if (__Init == InitMode.CREATE) break;
             default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot create where clause.");
           }
          S.setCharAt(Pos, ' ');
        }

       String Q = S.toString();
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(TILDA__DATELIMITDIM_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.DateLimitDim", Q, toString());

       return Q;
     }
   protected int populatePreparedStatement(Connection C, java.sql.PreparedStatement PS, List<java.sql.Array> AllocatedArrays) throws Exception
     {
       int i = 0;
       if (__Changes.intersects(TILDA__DATELIMITDIM_Factory.COLS.INVALIDDATE._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__DATELIMITDIM_Factory.COLS.INVALIDDATE._Mask) == true) PS.setNull(++i, java.sql.Types.DATE); else if (DateTimeUtil.isNowPlaceholder(_invalidDate) == false)  PS.setDate(++i, java.sql.Date.valueOf(_invalidDate));
        } 
       if (__Changes.intersects(TILDA__DATELIMITDIM_Factory.COLS.MINDATE._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__DATELIMITDIM_Factory.COLS.MINDATE._Mask) == true) PS.setNull(++i, java.sql.Types.DATE); else if (DateTimeUtil.isNowPlaceholder(_minDate) == false)  PS.setDate(++i, java.sql.Date.valueOf(_minDate));
        } 
       if (__Changes.intersects(TILDA__DATELIMITDIM_Factory.COLS.MAXDATE._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__DATELIMITDIM_Factory.COLS.MAXDATE._Mask) == true) PS.setNull(++i, java.sql.Types.DATE); else if (DateTimeUtil.isNowPlaceholder(_maxDate) == false)  PS.setDate(++i, java.sql.Date.valueOf(_maxDate));
        } 
       return i;
     }
   protected void stateUpdatePostWrite() throws Exception
     {
       if (__Init == InitMode.CREATE)
        {
          __Init = InitMode.WRITTEN;
          __LookupId = 0;
        }
       else
        {
          __Init = __Init == InitMode.READ ? InitMode.READ_WRITTEN : InitMode.WRITTEN;
        }

       switch (__LookupId)
        {
          case 0:
             __Saved_invalidDate = _invalidDate;
             break;
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot prepare statement.");
        }

       __Changes.clear();
     }
/**
 Writes the object to the data store using an upsert approach and assumes the object is either
 in create or deserialized mode. 
 The parameter createFirst controls whether the logic should do an insert first and if it fails, then do 
 an update, or the opposite (update first and if it fails, then an insert). This is necessary for databases
 without a robust upsert SQL syntax where separate insert/update statements must be issued.
 The method will figure out based on the fields set which natural identity (a unique index) is applicable for
 the lookup operation.
 Note that when you use upsert() (right after a create or deserialization initialization), only the template
 fields (not null, natural identity and/or any field set prior to calling this method) exist in memory. Call
 refresh() to force a select and retrieve all the fields for that record.
*/
   public final boolean upsert(Connection C, boolean updateFirst) throws Exception
     {
       boolean OK =    __Init == InitMode.CREATE && __NewlyCreated == true && __LookupId == SystemValues.EVIL_VALUE // Create() through factory
                    || __Init == null && __LookupId==0 // Loaded via some deserialization mechamism, e.g., Json or CSV loader
               ;
       if (OK == false)
        throw new Exception("Object has not been instanciated via deserialization or the factory create() method: __Init:"+__Init+"; __NewlyCreated:"+__NewlyCreated+"; __LookupId: "+__LookupId+";");

       if (__Init == null && __LookupId==0)  // object deserialized
        validateDeserialization();

       int lookupId = getFirstValidLookupBy();
       if (lookupId == SystemValues.EVIL_VALUE)
        throw new Exception("Object has not been intialized with sufficient data for any natural key to be available for a lookup.");

       if (updateFirst == true)
        {
          initForLookup(lookupId);
          if (write(C) == false)
           {
             initForCreate();
             return write(C);
           }
        }
       else
        {
          initForCreate();
          if (write(C) == false)
           {
             initForLookup(lookupId);
             return write(C);
           }
        }

       return true;
     }

   /**
   * Returns the first satisfied natural identify (i.e., unique indices), or if defined, the PK. by 'satisfied',
   * we mean an identity whose columns have all been provided (i.e., not null). We prioritize natural identities
   * over the PK since PKs are typically not stable across systems. For example, one might model a user with a PK
   * but also an identify over an email address for example. That email address for a given logical user should be
   * constant across multiple environments (e.g., a dev, staging or prod), where as a PK might be generated based
   * on dynamic factors that are very likely to be different across systems.
   */
   protected int getFirstValidLookupBy() throws Exception
     {

       // Testing if cols for unique index InvalidDate were set - Id: 0
       if (_invalidDate != null)
        return 0;

       return SystemValues.EVIL_VALUE;
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

   public final boolean refresh(Connection C) throws Exception
     {
       return readOne(C, true);
     }

   public final boolean read(Connection C) throws Exception
     {
       return readOne(C, false);
     }

   private final boolean readOne(Connection C, boolean Force) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE)
        throw new Exception("This TILDA.DateLimitDim object is being read() after a create(), which doesn't make sense.");
       if (__Init == InitMode.READ == true && Force == false && hasChanged()==false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "This TILDA.DateLimitDim object has already been read.");
          QueryDetails.setLastQuery(TILDA__DATELIMITDIM_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }
       StringBuilder S = new StringBuilder(1024);
          S.append("select ");
          C.getFullColumnVarList(S, TILDA__DATELIMITDIM_Factory.COLUMNS);
          S.append(" from "); C.getFullTableVar(S, "TILDA", "DateLimitDim");
       switch (__LookupId)
        {
          case 0: // Unique Index 'InvalidDate'
             S.append(" where ("); C.getFullColumnVar(S, "TILDA", "DateLimitDim", "invalidDate"); S.append("=?");  S.append(")");
             break;
          case -77: 
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot create where clause.");
        }

       String Q = S.toString();
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(TILDA__DATELIMITDIM_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.DateLimitDim", Q, toString());
       java.sql.PreparedStatement PS=null;
       java.sql.ResultSet RS=null;
       int count = 0;

       try
        {
          PS = C.prepareStatement(Q);
          int i = 0;
          switch (__LookupId)
           {
             case 0: // Unique Index 'InvalidDate'
               PS.setDate(++i, new java.sql.Date(_invalidDate.getYear()-1900, _invalidDate.getMonthValue()-1, _invalidDate.getDayOfMonth()));
               break;
             case -666: if (__Init == InitMode.CREATE) break;
             default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot prepare statement.");
           }


          RS = PS.executeQuery();
          if (RS.next() == false)
            {
              LOG.debug(QueryDetails._LOGGING_HEADER + "   No record was read.");
              return false;
            }
          count = 1;
          return init(C, RS);
        }
       catch (java.sql.SQLException E)
        {
          return C.handleCatch(E, "selected");
        }
       finally
        {
          tilda.data._Tilda.TILDA__2_5.handleFinally(PS, T0, TILDA__DATELIMITDIM_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
          PS = null;
        }
    }

   boolean init(Connection C, java.sql.ResultSet RS) throws Exception
    {
      int i = 0;
     __Init = InitMode.LOOKUP;
      __Saved_invalidDate = _invalidDate = DateTimeUtil.toLocalDate(RS.getDate(++i)); if (RS.wasNull() == true) { __Nulls.or(TILDA__DATELIMITDIM_Factory.COLS.INVALIDDATE._Mask); _invalidDate = null; }
                            _minDate     = DateTimeUtil.toLocalDate(RS.getDate(++i)); if (RS.wasNull() == true) { __Nulls.or(TILDA__DATELIMITDIM_Factory.COLS.MINDATE._Mask    ); _minDate = null; }
                            _maxDate     = DateTimeUtil.toLocalDate(RS.getDate(++i)); if (RS.wasNull() == true) { __Nulls.or(TILDA__DATELIMITDIM_Factory.COLS.MAXDATE._Mask    ); _maxDate = null; }
     __LookupId = 0;
     __Init     = InitMode.READ;
     __Changes.clear();

     return afterRead(C);
   }

   protected abstract boolean afterRead(Connection C) throws Exception;

   public String toString()
    {
      long T0 = System.nanoTime();
      String Str = 
                   "invalidDate: "                                                                                           +                                   getInvalidDate()
               + "; minDate: "                                                                                               +                                   getMinDate    ()
               + "; maxDate: "                                                                                               +                                   getMaxDate    ()
         + ";";
      PerfTracker.add(TransactionType.TILDA_TOSTRING, System.nanoTime() - T0);
      return Str;
    }

   public void toJSON(java.io.Writer out, String exportName, boolean fullObject) throws Exception
    {
      toJSON(out, exportName, "", fullObject, false);
    }
   public void toJSON(java.io.Writer out, String exportName, String lead, boolean fullObject) throws Exception
    {
      toJSON(out, exportName, lead, fullObject, false);
    }
   public void toJSON(java.io.Writer out, String exportName, String lead, boolean fullObject, boolean noNullArrays) throws Exception
    {
      switch (exportName)
        { 
          case "": tilda.data.DateLimitDim_Factory.toJSON(out, (tilda.data.DateLimitDim_Data) this, lead, fullObject, noNullArrays); break;
          default: throw new Exception("Unknown JSON exporter '"+exportName+"' for tilda.data.DateLimitDim_Factory");
        } 
    }
   public void toJSON(java.io.Writer out, String exportName, String lead, boolean fullObject, java.time.ZonedDateTime lastsync) throws Exception
    {
      throw new Exception("Unknown JSON sync exporter '"+exportName+"' for tilda.data.DateLimitDim_Factory");
    }
   public void toCSV(java.io.Writer out, String exportName) throws Exception
    {
      switch (exportName)
        { 
          case "": tilda.data.DateLimitDim_Factory.toCSV(out, (tilda.data.DateLimitDim_Data) this); break;
          default: throw new Exception("Unknown CSV exporter '"+exportName+"' for tilda.data.DateLimitDim_Factory");
        } 
    }
   public void toCSV(java.io.Writer out, String exportName, java.time.ZonedDateTime lastsync) throws Exception
    {
      throw new Exception("Unknown CSV sync exporter '"+exportName+"' for tilda.data.DateLimitDim_Factory");
    }
 }
