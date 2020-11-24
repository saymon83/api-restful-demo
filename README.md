# api-restful

API RESTful for user authentication using Java, Spring and JWT.

## Root URL

https://github.com/saymon83/api-restful-demo/

## Endpoints

### User Registration


User registration and place with the evaluation.

#### URL

/signup

#### Method:

  `POST`

#### Data Params:
```
{
  "firstName": "Bruno",
  "lastName": "Silva",
  "email": "3bruno@world.com",
  "password": "bruno33",
  "phones": [
    {
      "number": 988887885,
      "area_code": 81,
      "country_code": "+55"
    }
  ],
  "local": [
    {
      "id": 988887888,
      "nome": "Recife",
	  "avaliacao" :5,
	  "comentario" : "Capital Pernanbucano"
    },
    {
      "id": 988887885,
      "nome": "Olinda",
	  "avaliacao" :3,
	  "comentario" : "Pernanbucano"
    }
  ]
}
```
#### Success Response:

###### Code: 200 OK

###### Content:

    {
      "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c"
    }

#### Error Response:

###### Code: 400 BAD REQUEST

###### Content:

    {
      "message": "E-mail already exists"
      "code": "400"
    }

OR

###### Code: 400 BAD REQUEST

###### Content:

    {
      "message": "Invalid fields"
      "code": "400"
    }
    
OR

###### Code: 400 BAD REQUEST

###### Content:

    {
      "message": "Missing fields"
      "code": "400"
    }

### User Authentication
Validates credentials and returns a token.


#### URL

/signin

#### Method:

  `POST`

#### Data Params:

    {
      "email": "3bruno@world.com",
      "password": "bruno33"
    }

#### Success Response:

###### Code: 200 OK

###### Content:

    {
      "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c"
    }

#### Error Response:

###### Code: 400 BAD REQUEST

###### Content:

    {
      "message": "Invalid e-mail or password"
      "code": "400"
    }

OR

###### Code: 400 BAD REQUEST

###### Content:

    {
      "message": "Missing fields"
      "code": "400"
    }

### User Details


Return details.

#### URL

/me

#### Method:

  `GET`

#### Success Response:

###### Code: 200 OK

###### Content:
```
   {
    "firstName": "Bruno",
    "lastName": "Silva",
    "email": "bruno@world.com",
    "phones": [
        {
            "number": 988887884,
            "area_code": 81,
            "country_code": "+55"
        }
    ],
    "local": [
        {
            "id": 988887887,
            "nome": "Recife",
            "avaliacao": 1,
            "comentario": "Capital Pernanbucano"
        },
        {
            "id": 988887884,
            "nome": "Olinda",
            "avaliacao": 3,
            "comentario": "Pernanbucano"
        }
    ],
    "created_at": "2020-11-13T18:32:56.223+0000",
    "last_login": "2020-11-13T18:38:05.380+0000"
}
```

#### Error Response:

###### Code: 401 UNAUTHORIZED

###### Content:

    {
      "message": "Unauthorized"
      "code": "401"
    }

OR

###### Code: 401 UNAUTHORIZED

###### Content:

    {
      "message": "Unauthorized - invalid session"
      "code": "401"
    }
