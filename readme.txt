springMVC 与mongoDB 整合

net.hubs1.com.repository.PerRepository extends  MongoRepository<PersonData,String> {}

PersonRepository extends  MongoRepository<PersonData,String> {}


mongodb 接口 继承 MongoRepository 

但是MongoRepository实现了的只是最基本的增删改查的功能，要想增加额外的查询方法，
可以按照以下规则定义接口的方法。

自定义查询方法，格式为“findBy+字段名+方法后缀”，

方法传进的参数即字段的值，此外还支持分页查询，

通过传进一个Pageable对象，返回Page集合。


GreaterThan(大于) 
findByAgeGreaterThan(int age) 
{"age" : {"$gt" : age}}

LessThan（小于） 
findByAgeLessThan(int age) 
{"age" : {"$lt" : age}}

Between（在...之间） 
findByAgeBetween(int from, int to) 
{"age" : {"$gt" : from, "$lt" : to}}

IsNotNull, NotNull（是否非空） 
findByFirstnameNotNull() 
{"age" : {"$ne" : null}}

IsNull, Null（是否为空） 
findByFirstnameNull() 
{"age" : null}

Like（模糊查询） 
findByFirstnameLike(String name) 
{"age" : age} ( age as regex)

(No keyword) findByFirstname(String name) 
{"age" : name}

Not（不包含） 
findByFirstnameNot(String name) 
{"age" : {"$ne" : name}}

Near（查询地理位置相近的） 
findByLocationNear(Point point) 
{"location" : {"$near" : [x,y]}}

Within（在地理位置范围内的） 
findByLocationWithin(Circle circle) 
{"location" : {"$within" : {"$center" : [ [x, y], distance]}}}

Within（在地理位置范围内的） 
findByLocationWithin(Box box) 
{"location" : {"$within" : {"$box" : [ [x1, y1], x2, y2]}}}