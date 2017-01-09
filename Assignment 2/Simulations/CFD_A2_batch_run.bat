START "job1-CM" /wait "C:\Program Files\CD-adapco\STAR-CCM+10.04.008-R8\star\bin\starccm+.exe" -np 6 -batch export_animations_CM.java -hardwarebatch  "DWing-waves-CM.sim"

START "job1-CT" /wait "C:\Program Files\CD-adapco\STAR-CCM+10.04.008-R8\star\bin\starccm+.exe" -np 6 -batch export_animations_CT.java -hardwarebatch  "DWing-waves-CT.sim"

START "job-FT" /wait "C:\Program Files\CD-adapco\STAR-CCM+10.04.008-R8\star\bin\starccm+.exe" -np 6 -batch export_animations_FT.java -hardwarebatch   "DWing-waves-FT.sim" 

START "job1-FM" /wait "C:\Program Files\CD-adapco\STAR-CCM+10.04.008-R8\star\bin\starccm+.exe" -np 6 -batch export_animations_FM.java -hardwarebatch  "DWing-waves-FM.sim" 
