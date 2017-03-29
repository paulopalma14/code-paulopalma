Dim message, sapi
 message = InputBox("A Best Text to Audio converter","Text to Audio converter")
 Set sapi = CreateObject("sapi.spvoice")
 sapi.Speak message