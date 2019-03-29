# Duffy:
~~~
@GetMapping("/api/user/fridges")
@RequestParam Long id
[
    {
        "id": 1,
        "name": "bazmegduffy",
        "postIts": [],
        "users": [
            {
                "id": 1,
                "name": "devil",
                "email": "devil@hell.com",
                "postIts": []
            }
        ],
        "admin": "devil"
    }
]
~~~
~~~
@GetMapping("/api/user/postits")
@RequestParam Long id
[
    {
        "id": 1,
        "content": "tessék duffy!",
        "type": "posztit"
    }
]
~~~


> *(Erről még beszélnünk kell!!!!! - Duffy)*
~~~
@GetMapping("/api/user")
@RequestParam Long id
{
    "id": 1,
    "name": "devil",
    "email": "devil@hell.com",
    "fridges": [
        {
            "id": 1,
            "name": "bazmegduffy",
            "postIts": [
                {
                    "id": 1,
                    "content": "tessék duffy!",
                    "type": "posztit"
                }
            ],
            "admin": "devil"
        }
    ],
    "postIts": [
        {
            "id": 1,
            "content": "tessék duffy!",
            "type": "posztit"
        }
    ]
}
~~~

> *(Erről is még!!!! - Duffy)*
~~~
@PostMapping("/api/user")
UserModel userModel
No return (HttpStatus.OK)
~~~

~~~
@DeleteMapping("/api/user")
@RequestParam Long id
No return (HttpStatus.OK)
~~~

# Kiki
## FridgeController
~~~
@GetMapping("/api/fridges/{fridgeId}")
@PathVariable ("fridgeId") Long fridgeId
~~~

~~~
@PostMapping("/api/fridges")
Fridge fridge
~~~

~~~
@DeleteMapping("/api/fridges/{fridgeId}")
@PathVariable ("fridgeId") Long fridgeId
~~~
## PostItController
~~~
@GetMapping("/api/postits")
@RequestParam(value = "fridgeId", required = false) Long fridgeId,
@RequestParam(value = "userId", required = false) Long userId)
[{"id":1,"content":"tessék duffy!","type":"posztit"}]
Vagy ha valamely param hiányzik, semmi & bad request;
~~~

~~~
@PostMapping("/api/postits")
PostIt postIt
No return (HttpStatus.OK)
~~~

~~~
@DeleteMapping("/api/postits")
@RequestParam("postitid") Long postitId
No return (HttpStatus.OK)
~~~
