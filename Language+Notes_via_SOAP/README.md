#Service launch
docker-compose up --build -d <br>

## Access
{url}/languages?wsdl <br>
POST to {url}/languages

## Examples

grazina vienos kalbos  informacija

<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:getLanguage xmlns:ns2="http://SOAP/">
        	<id>1</id>
        </ns2:getLanguage>
    </S:Body>
</S:Envelope>

grazina visas kalbas

<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:getLanguages xmlns:ns2="http://SOAP/">
        </ns2:getLanguages>
    </S:Body>
</S:Envelope>

updatina kalbos info

<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:putLanguage xmlns:ns2="http://SOAP/">
        	<id>4</id>
        	<language>newLang</language>
        	<is_object_oriented>false</is_object_oriented>
			<strongly_typed>false</strongly_typed>
        </ns2:putLanguage>
    </S:Body>
</S:Envelope>

istrina kalba su jo related notes:

<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:deleteLanguage xmlns:ns2="http://SOAP/">
        	<id>2</id>
        </ns2:deleteLanguage>
    </S:Body>
</S:Envelope>

prideti kalba:

<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:addLanguage xmlns:ns2="http://SOAP/">
        	<language>anotherNewLang</language>
        	<is_object_oriented>true</is_object_oriented>
			<strongly_typed>true</strongly_typed>
        </ns2:addLanguage>
    </S:Body>
</S:Envelope>

kalbos notes:

<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:getLanguageNotes xmlns:ns2="http://SOAP/">
        	<id>1</id>
        </ns2:getLanguageNotes>
    </S:Body>
</S:Envelope>

prideti note kalbai:

<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:addLanguageNote xmlns:ns2="http://SOAP/">
        	<id>1</id>
        	<title>pavadinimas87</title>
        	<comment>komentaras554</comment>
        	<expiration>laikas</expiration>
			<author>authoras</author>
        </ns2:addLanguageNote>
    </S:Body>
</S:Envelope>

istrinti nurodyta kalbos note:

<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:deleteLanguageNote xmlns:ns2="http://SOAP/">
        	<id>1</id>
        	<title>default1</title>
        	</ns2:deleteLanguageNote>
    </S:Body>
</S:Envelope>

gauti visus kalbas su ju notes:

<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:getLanguagesEmbedded xmlns:ns2="http://SOAP/">
        	</ns2:getLanguagesEmbedded>
    </S:Body>
</S:Envelope>

