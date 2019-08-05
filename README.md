<P align="center"><IMG src="Tilda.jpg"></P>
<H1>Intro</H1>
Tilda (Transparent Integrated Light Data Architecture) is not an ORM, but an integrated data platform that takes a base-level view from the database schema level, and projects it out to various programming environments. It provides a JSON-based configuration language to define basic tables/objects, and higher level patterns such as Exporters, History, Datamarts, Pivots, Datamats, Formulas etc... It generates code so can focus on your business logic. It automates migration, deployments (in single-database or multi-tenant fashion), documentation, and increases team velocity working with complex data models from design to deployment.<BR>
<BR>
This work is based on ideas and experience gathered building large data systems and complex applications, from CORBA runtimes and EJB containers, to Hibernate-based or myBatis systems, and more recently, a full-fledged real-time clinical analytics platform. Tilda aims to be as transparent and simple as possible for the modern data engineer, providing a fairly flat view of your data in plain SQL and/or code artifacts and projecting across multiple tiers of your application. It's transparency is critical in helping use Tilda simply as a model management tool with minimal adoption risk, or as a full fledge ETL and data application building block (the all-in approach). All assets generated are human-readable from the get go and is easy to walk through and understand if need be. But you don't have to. Tilda takes a decidely data-centric view of the world: we believe you cannot build a complex large-scale performing data application without thinking about it full-stack, and it all starts at the data model level. <B>we believe that no framework can hide your database, so why try</B>? This is Data to the metal, and all the way up full stack.<BR>
<BR>
At this time, Tilda only supports Java 1.8+ as a target language, and Postgres 9.5+ as a target Database. However, the framework was built to support other languages (such as JavaSCript or .Net for example), and other data stores (MS SQL Server, mySQL, and also non-relational backends such as Cassandra,  MongoDB or Hadoop). Ultimately, we are aiming for an extensible data architecture that would enable integration with different formats, such as CSV, or HL7 (a standard healthcare data exchange format), and the ability to extend the patterns supported (feeding data to predictive models for example). Tilda ultimately strives at identifying core patterns used in a complex data-driver application, and capture them as reusable declarative bits so you can assemble them to match your needs.<BR>

<H1>Docs</H1>
We are making progress on the <A href="https://github.com/CapsicoHealth/Tilda/wiki">Wiki</A> and started publishing the <A href="https://capsicohealth.github.io/Tilda/overview-summary.html">JavaDocs</A> for the project.
 
<H1>License</H1>
Licensed under the Apache License, Version 2.0 (the "License"); you may not use this code except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

The copyright is retained by CapsicoHealth Inc as Copyright (C) 2015 CapsicoHealth Inc.

<H1>Setting up the code</H1>
The code is currently setup as an Eclipse Java project. Once you fork/clone the repo, you should be able to simply
import the project into your workspace. Tilda is all self-contained at this time, and can generally be used as
a base project, for your application. You can also of course build your own JAR and take the libraries independently.

<H1>Dependencies</H1>
Tilda is currently dependent on several other <A href="https://github.com/CapsicoHealth/Tilda/tree/master/lib">libraries</A> both for the tooling and at runtime such as:
  <UL><LI><A href="https://commons.apache.org/proper/commons-dbcp/">Apache Commons DPCP2</A>
      <LI> <A href="https://commons.apache.org/proper/commons-io/">Apache Commons IO</A>
      <LI> <A href="https://commons.apache.org/proper/commons-logging/">Apache Commons Logging</A>
      <LI> <A href="https://commons.apache.org/proper/commons-pool/">Apache Commons Pool2</A>
      <LI> <A href="http://lmax-exchange.github.io/disruptor/">LMAX Disruptor</A>
      <LI> <A href="https://code.google.com/p/google-gson/">GSON</A>
      <LI> <A href="http://logging.apache.org/log4j/2.x/">Apache Log4j 2</A>
      <LI> <A href="https://jdbc.postgresql.org/">Postgres JDBC driver</A>
  </UL>

<H1>Additional utilities</H1>
In order to support its tooling and runtime, Tilda also includes a number of <A href="https://github.com/CapsicoHealth/Tilda/tree/master/src/tilda/utils">utilities</A> such as:
  * DateTime and Timezone support
  * Text for formating utilities
  * Encryption
  * HTML inspection
  * etc...

You are free to use those in your application if they fit your needs. However, we are always in the lookout to use other libraries if their functionality matches our needs, so it's very possible that over time, some of the Tilda utilities get deprecated and phased out.

<H1>Getting started</H1>
We are working on getting-started tutorials and videos that will live in the <a href="https://github.com/CapsicoHealth/Tilda/wiki">Wiki</A>.

