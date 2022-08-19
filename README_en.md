# p40-clipsjni-051

[Spanish](https://github.com/dpsframework/p40-clipsjni-051/)



## How to build the libraries for each architecture and how to perform a full check

- From console


## Proposal description and status

- **status**:  'Completed'
- **title**:  'Proposal: native library dual self-location of CLIPSJNI-0.51'
- **subtitle**:  'Proposal to update CLIPS-JNI-0.51 to facilitate the detection of the machine architecture and location of the native library at runtime'
- **abstract**:  'The CLIPSJNI-051 Java component allows Java to be connected to the CLIPS core developed in C++. This proposal provides a proven solution for detecting the architecture of the machine at runtime, in addition to incorporating additional security enhancements. It is oriented to be used by JADE PS-Agents with problem resolution capabilities. However, it can be useful in any application that requires CLIPS 6.31 connectivity from Java.'

##  To-Do List:
- [x]  \(1) Achieve compliance of CLIPSJNI with Java Platform Module System (JPMS)[^migra17] development specifications.
- [x]  \(2) Allow compilation from Java[^java] versions JDK-11 through JDK-17 LTS (2022-2029) and higher. 
- [x]  \(3) Optimize performance of CLIPSJNI-0.51 within the Agent behaviors of the JADE platform.
- [x]  \(4) Incorporate build step sequence files for different architectures.
- [x]  \(5) Carry out the CLIPS 6.31 tests on a Node-type Agents console.
- [x]  \(6) Prepare as a GitHub repository for download and evaluation of the proposal.









  

##   Section 1: Identification
-  Responsible for the proposal: _FJ Aguayo_.
-  Proposal date: April, 2022.
-  Results location: GitHub repo.

##   Section 2: Process
-  The CLIPS-JNI version 0.51 Java native interface for CLIPS 6.31[^1]  has been reviewed by _Gary Riley_ on 2019-08-06. The source code is available on the Source forge at <https://sourceforge.net/projects/clipsrules/files/CLIPS/6.31/>.
-  JADE[^jade] agents capable of integrating and executing autonomous Expert Systems on the Multi-Agent platform require prior knowledge of the architecture of the Java machine and the hardware on which they are executed.

###  2.1. Description of the proposal:

-  Carry out a development on CLIPS-JNI-0.51 so that this interface detects which is the Java machine and the hardware architecture of the node where the Multi-Agent system is executed, and in this way, the CLIPSJNI Library itself associates and links with its library native in C++.
-  The development of the additional security elements was carried out by adjusting the visibility of the fundamental Objects that make up the CLIPS-JNI-0.51 library.

###  2.2. target platform
-  Java JDK-11[^java] through JDK-18[^migra17]. OpenJDK-18[^openJDK]. CLIPS 6.31
  
-  JADE Troubleshooting Agents, version 1.9 or higher.




###  23. What does the proposal need for its execution?
-  ECLIPSE IDE 2022.
-  CLIPS 6.31 source-code. CLIPS-JNI-0.51 source-code.
-  JADE PS Agents version 1.9 or higher.
-  CLIPS 6.31 test[^cool]

###  2.4. Why this proposal?
-  Because the dpsAgents-1.8-full.jar library, developed for JAVA 1.8, is not capable of linking the autonomous expert systems of JADE agents, with the CLIPS 6.31 kernel, nor with CLIPS 6.40.
-  Because the detection and link mechanism between the Agent and CLIPS or Prolog must be done by the native library, in an early link, eliminating the need for the agent to locate the location of the Native Library for OS-X, Gnu-Linux , Windows 32bits or Windows 64bits.






###  2.5. Underlying technology or technologies:
-  CLIPS
-  COOL
-  Java
-  lisp








###  2.6. Name of the generated library?
-    clipsjni-051ps-i586.jar
-    clipsjni-051ps-amd64.jar
etc.












###  2.7. Dependencies on specific operating systems
-  None.












###  2.8. Security issues due to the current security model
-  Does not apply to this project














###  2.9. Internationalization or localization problems?
-  They have not been implemented.















###  2.10. Any need for revision as a result of this work?
-  It has not been planned. Awaiting review.
















###  2.11. Schedule for the development of this proposal
-   Start: **April 2022**
-   End: **August 2022**
















##   Section 3: Contributions




###  3.1. Documents, proposals or implementations that describe the technology.















###  3.2. Starting point of the work.
-   CLIPSJNI-051 on Source Forge at: https://sourceforge.net/projects/clipsrules/files/CLIPS/6.31/clips_jni_051.tar.gz/download



















##   Section 4: Additional Information (Optional)












###  4.1. Additional information to include in the Improvement Proposal
  
  








##  _References_

[^1]: CLIPS Rule Based Programming Language Files. Expert System Tool. Gary, Riley D. (Ed. 2022). URL: https://sourceforge.net/projects/clipsrules/.

[^java]: ORACLE Java 17 is the latest long-term support (LTS) release under Java's six-month release cadence and is the result of extensive collaboration between Oracle engineers and other members of the worldwide Java developer community via the OpenJDK Community and the Java Community Process (JCP). Verificada con la versioón jdk-17.0.3.1 (junio, 2022). https://www.oracle.com/news/announcement/oracle-releases-java-17-2021-09-14/.

[^jade]:    JADE Platform. jade - Revision 6867: /trunk. https://jade.tilab.com/svn/jade/trunk/  Login/passwod: jade/jade. Version 4.5.4 (abril, 2022).

[^migra17]: Significant Changes in JDK 17 Release. Notes for additional descriptions of the new features and enhancements, and API specification in JDK 17. Updates in Java SE 17 and JDK 17: https://docs.oracle.com/en/java/javase/17/migrate/significant-changes-jdk-release.html

[^openJDK]: OpenJDK 17 is the open-source reference implementation of version 17 of the Java SE Platform, as specified by by JSR 390 in the Java Community Process. JDK 17 reached General Availability on 14 September 2021. URL for OpenJDK-11 is: https://openjdk.java.net/projects/jdk/11/. URL for OpenJDK-17 is: https://openjdk.java.net/projects/jdk/17/.

[^cool]: COOL is the acronym for CLIPS Object Oriented Language.





