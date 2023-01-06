@echo off
start "HelidonS1" C:\Users\User\Downloads\mp01\mp01\build\install\mp01\bin\mp01.bat -Dserver.port=8081 com.distribuida.Servidor
start "HelidonS2" C:\Users\User\Downloads\mp01\mp01\build\install\mp01\bin\mp01.bat -Dserver.port=8082 com.distribuida.Servidor
start "HelidonS3" C:\Users\User\Downloads\mp01\mp01\build\install\mp01\bin\mp01.bat -Dserver.port=8083 com.distribuida.Servidor
start "HelidonS4" C:\Users\User\Downloads\mp01\mp01\build\install\mp01\bin\mp01.bat -Dserver.port=8084 com.distribuida.Servidor