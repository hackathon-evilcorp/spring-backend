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


@GetMapping("/api/user/postits")
@RequestParam Long id
[
    {
        "id": 1,
        "content": "tessék duffy!",
        "type": "posztit"
    }
]


(Erről még beszélnünk kell!!!!! - Duffy)
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


(Erről is még!!!! - Duffy)
@PostMapping("/api/user")
UserModel userModel
No return (HttpStatus.OK)


@DeleteMapping("/api/user")
@RequestParam Long id
No return (HttpStatus.OK)
