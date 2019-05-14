
grazina vieno zmogaus informacija

<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:getLanguage xmlns:ns2="http://SOAP/">
        	<id>4</id>
        </ns2:getLanguage>
    </S:Body>
</S:Envelope>

grazina visus zmones

<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:getLanguages xmlns:ns2="http://SOAP/">
        </ns2:getLanguages>
    </S:Body>
</S:Envelope>

updatina zmogaus info

<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:putLanguage xmlns:ns2="http://SOAP/">
        	<id>4</id>
        	<name>new name</name>
        	<email>new email</email>
        </ns2:putLanguage>
    </S:Body>
</S:Envelope>

istrina zmogu su jo related notes:

<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:deleteLanguage xmlns:ns2="http://SOAP/">
        	<id>2</id>
        </ns2:deleteLanguage>
    </S:Body>
</S:Envelope>

prideti zmogu:

<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:addLanguage xmlns:ns2="http://SOAP/">
        	<name>new name</name>
        	<email>new name</email>
        </ns2:addLanguage>
    </S:Body>
</S:Envelope>

zmogaus notes:

<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:getLanguageNotes xmlns:ns2="http://SOAP/">
        	<id>1</id>
        </ns2:getLanguageNotes>
    </S:Body>
</S:Envelope>

prideti note zmogui:

<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:addLanguageNote xmlns:ns2="http://SOAP/">
        	<id>1</id>
        	<title>pavadinimas</title>
        	<comment>komentaras</comment>
        	<expiration>laikas</expiration>
        </ns2:addLanguageNote>
    </S:Body>
</S:Envelope>

gauti viena nurodyta zmogaus note:

<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:getLanguageNote xmlns:ns2="http://SOAP/">
        	<id>1</id>
        	<title>pavadinimas</title>
        	</ns2:getLanguageNote>
    </S:Body>
</S:Envelope>

atnaujinti nurodyta zmogaus note (id, title):

<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:putLanguageNote xmlns:ns2="http://SOAP/">
        	<id>1</id>
        	<title>pavadinimas</title>
        	<comment>komentaras</comment>
        	<expiration>a</expiration>
        	</ns2:putLanguageNote>
    </S:Body>
</S:Envelope>

istrinti nurodyta zmogaus note:

<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:deleteLanguageNote xmlns:ns2="http://SOAP/">
        	<id>2</id>
        	<title>pavadinimas</title>
        	</ns2:deleteLanguageNote>
    </S:Body>
</S:Envelope>

gauti visus zmones su ju notes:

<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:getLanguagesNotes xmlns:ns2="http://SOAP/">
        	</ns2:getLanguagesNotes>
    </S:Body>
</S:Envelope>

prideti zmogu kartu su note:

<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:addLanguageWithNote xmlns:ns2="http://SOAP/">
        	<name>vardas</name>
        	<email>emailas</email>
        	<title>pavadinimas</title>
        	<comment>komentaras</comment>
        	<expiration>a</expiration>
        	</ns2:addLanguageWithNote>
    </S:Body>
</S:Envelope>
