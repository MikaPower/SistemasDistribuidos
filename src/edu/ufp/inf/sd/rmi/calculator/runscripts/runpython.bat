@REM ************************************************************************************
@REM Description: run Pingclient
@REM Author: Rui Moreira
@REM Date: 20/02/2005
@REM ************************************************************************************
@REM Script usage: runclient <role> (where role should be: server / client)
@REM call setclientenv
call setenv client

@REM Run python on *build/classes* or *dist* directory
@cd %ABSPATH2CLASSES%
@REM cd %ABSPATH2DIST%
@cls
@REM python 3:
@REM python -m http.server 8000
@REM python 2.7:
C:\Users\nunoalfhotmail.com\AppData\Local\Programs\Python\Python37-32\python.exe -m http.server 8000

@cd %ABSPATH2SRC%\%JAVASCRIPTSPATH%