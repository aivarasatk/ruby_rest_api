# ruby_rest_api
A project for a web services. Service lets to store information about programming languages.

## Installation with docker
git clone https://github.com/aivarasatk/ruby_rest_api.git <br>
sudo docker-compose up --build -d <br>

## Access the app
POST {url}/languages <br>
GET {url}/languages <br>
GET {url}/languages/{id} <br>
PUT {url}/languages/{id} <br>
PATCH {url}/languages/{id} <br>
DELETE {url}/languages/{id} <br>

## Examples:
*  Successful POST example: <br>
```javascript
{
        //note: do not supply an id
        "language": "Pythoniukas",
        "is_object_oriented": true,
        "reserved_words": [
            "if",
            "echo"
        ],
        "strongly_typed": false,
        "popular_editor": "Visual Studio", //optional
        "release_year": 2000, //optional
        "creator": "Microsoft" //optional
}
```
*  An array of objects can also be POST'ed
*  PUT example is same as POST
*  PATCH can be used with any field combination (no id in payload still stands)
