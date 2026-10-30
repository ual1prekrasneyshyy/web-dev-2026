The project represents a news portal, where user can list, view, add, update and delete some article of the news.
Initially, 2 articles will be stored at database by migration.
The entity contains columns such as id, title, content, views (number of views) and post date.
When we add or update article, we can set only title and content. The identifier, number of views and post date will be set up by the application automaticall.
Each time user fetches an article by id to view, the number of views will be increased.

The swagger is avaliable by the link: http://localhost:8081/swagger-ui/index.html
The specification: http://localhost:8081/v3/api-docs

View list of news:
![img.png](img.png)

View article by ID:
![img_1.png](img_1.png)

Trial to view article with fake ID:
![img_2.png](img_2.png)

Add article:
![img_3.png](img_3.png)

Update article:
![img_4.png](img_4.png)

Trial to update article with fake ID:
![img_5.png](img_5.png)

Delete article:
![img_6.png](img_6.png)

Trial to delete article with fake ID:
![img_7.png](img_7.png)