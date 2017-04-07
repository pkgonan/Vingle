# Vingle

- Purpose
  
  : API Control Project

#
- How To Test

   : Used By CURL
   

<Test 1>

    curl -XPOST "http://localhost:8080/register.json?url=http://www.vingle.net"

    curl -XPOST "http://localhost:8080/register.json?url=http://www.naver.com"
    
    curl -XPOST "http://localhost:8080/register.json?url=http://www.daum.net"
    
    
    
<Test 2>

    curl -XGET "http://localhost:8080/1
    
    curl -XGET "http://localhost:8080/2
    curl -XGET "http://localhost:8080/2
    
    curl -XGET "http://localhost:8080/3
    curl -XGET "http://localhost:8080/3
    curl -XGET "http://localhost:8080/3
    
    
<Test 3>

    curl -XGET "http://localhost:8080/1/stats        => Access Count : 1
    
    curl -XGET "http://localhost:8080/2/stats        => Access Count : 2
    
    curl -XGET "http://localhost:8080/3/stats        => Access Count : 3