# Language service + Notes

### Language service expanded with possiblity to have notes.<br>
Notes are managed using another service SOA (https://github.com/plssts/SOA)<br>
Original service is expanded with a array of note titles<br>

# Launch services
docker-compose up --build -d <br>

## Access the app
All previous paths plus: <br>
POST   {url}/languages/{id}/notes <br>
GET    {url}/languages?embedded=notes <br>
GET    {url}/languages/{id}/notes <br>
DELETE {url}/languages/{id}/notes/{note_title} <br>

## Successful notes POST example: <br>
```javascript
{
    "title":"someTitle",
    "author":"aiv",
    "comment":"new one",
    "expiration": "2020-12-12"
}
```
<br>
<br>

Information about notes can be found here: https://github.com/plssts/SOA first assignment

