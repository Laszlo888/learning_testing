SOAP request:
<?xml version="1.0"?>
<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:m="http:/example.com/exampleapi">
  <soap:Header>
  </soap:Header>
  <soap:Body>
    <m:GetUser>
      <m:UserId>123</m:UserId>
    </m:GetUser>
  </soap:Body>
</soap:Envelope>

What does the SOAP message represent?
	felhasználói azonosító
	
What are the input properties?
	GetUser,UserId
	
What XML Namespaces are declared?
	xmlns:soap="http://www.w3.org/2003/05/soap-envelope" 
	xmlns:m="http:/example.com/exampleapi"
	
	
SOAP response:
<?xml version="1.0"?>
<soap:Envelope
xmlns:soap="http://www.w3.org/2003/05/soap-envelope/"
soap:encodingStyle="http://www.w3.org/2003/05/soap-encoding"
xmlns:m="http:/example.com/exampleapi">
<soap:Body>
  <m:GetUserResponse>
    <m:Username>Tony Stark</m:Username>
  </m:GetUserResponse>
</soap:Body>
</soap:Envelope>


What did the web service respond with?
	Tony Stark

What XML Namespaces are declared?
	xmlns:soap="http://www.w3.org/2003/05/soap-envelope/"
	xmlns:m="http:/example.com/exampleapi">