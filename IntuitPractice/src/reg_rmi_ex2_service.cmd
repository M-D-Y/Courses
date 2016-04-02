echo of
cls
set s = %~dp0
cd ..\bin
echo on
rmic -v1.2 com.asw.rmi.ex2.BillingServiceImpl -classpath .
rmiregistry
cd %s%
pause