# Language service + Notes

### Language service expanded with possiblity to have notes.<br>
Notes are managed using another service SOA (https://github.com/plssts/SOA)<br>
Original service is expanded with a array of note titles<br>

# Launch services
Clone this repository with git clone https://github.com/aivarasatk/ruby_rest_api <br>

Navigate to LanguageService+Notes/2 and execute ./init.sh. This will build and link all needed services. You might need to provide necessary permissions to execute the file with chmod +x init.sh. <br>

It is recommended to execute ./cleanup.sh (again, make this file executable with chmod +x cleanup.sh if needed) after finishing using the service. This will stop running services, remove the dedicated network bridge and clean images. <br>

## Access the app
All previous paths plus: <br>
POST   {url}/languages/{id}/notes <br>
GET    {url}/languages/{id}/notes <br>
DELETE {url}/languages/{id}/notes/{note_title} <br>

## Successful notes POST example: <br>
```javascript
{
    "title":"rev",
    "author":"aiv",
    "comment":"new one",
    "expiration": "2020-12-12"
}
```
<br>
<br>

Information about notes can be found here: https://github.com/plssts/SOA first assignment

