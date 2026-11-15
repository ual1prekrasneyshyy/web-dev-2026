In this project I have three models: Course, Group, Student

The relations between them are:
<ul>
<li>
    Many-To-Many: Course-Group
</li>
<li>
    One-To-Many: Group-Student
</li>
</ul>

As for endpoints that works with related data, here I can mention:
<ul>
<li>
/groups/take-course: this adds course to some group by taking identifiers of both group and course in a HTTP-body
</li>
<li>
/students/join-group: this adds student to the group. Before adding to the group, system validates if the student has already joined to some group or not. If not, he or she can be joined.
</li>
</ul>

Exception handling also has been implemented in the REST controller. If custom exception will be thrown because of user input mistakes (e.g. attempt to find object with invalid identifier), the system will return either Not found or Bad request code. If system error will happen, the internal server error message will be return as a response code.

The swagger ui can be seen by the following endpoint: /swagger-ui/index.html

Swagger documentation and postman collection export also present in the repository
