set LIB=C:\Projects\Project7\bin
set JAVAEXE="C:\Program Files\Java\jdk8\bin\java.exe" -Xms192M -Xmx256M -cp "%CLASSPATH%;%LIB%\*;.\*"

@ECHO OFF
set P01=%1
set P02=%2
set P03=%3
set P04=%4
set P05=%5
set P06=%6
set P07=%7
set P08=%8
set P09=%9
shift
shift
shift
shift
shift
shift
shift
shift
shift
set P10=%1
set P11=%2
set P12=%3
set P13=%4
set P14=%5
set P15=%6
set P16=%7
set P17=%8
set P18=%9
shift
shift
shift
shift
shift
shift
shift
shift
shift
set P19=%1
set P20=%2
set P21=%3
set P22=%4
set P23=%5
set P24=%6
set P25=%7
set P26=%8
set P27=%9
shift
shift
shift
shift
shift
shift
shift
shift
shift
set P28=%1
set P29=%2
set P30=%3
set P31=%4
set P32=%5
set P33=%6
set P34=%7
set P35=%8
set P36=%9
@ECHO ON

%JAVAEXE% %P01% %P02% %P03% %P04% %P05% %P06% %P07% %P08% %P09% %P10% %P11% %P12% %P13% %P14% %P15% %P16% %P17% %P18% %P19% %P20% %P21% %P22% %P23% %P24% %P25% %P26% %P27% %P28% %P29% %P30% %P31% %P32% %P33% %P34% %P35% %P36% 
