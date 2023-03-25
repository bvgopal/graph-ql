Prerequisites=>
SpringBoot Version-2.7.x


To access Graphql UI=>
http://localhost:8080/graphiql

type below scripts and verify results.paly around removing elements and verify results.

To Execute authors=>
query {
authors {
id
name
books{
id
title
publisher
}
}
}


To execute authorById=>
query {
authorById(id: 2) {
id
name    
}
}


To execute authors & authorById=>
query {
authors {
id
name
books{
id
title
publisher
}
}
authorById(id: 2) {
id
name    
}
}



To access H2 database=>
http://localhost:8080/h2-console

To add Book =>
mutation {
addBook(book: {title:"Spring-graph-ql in action", publisher:"Kish", authorId:6}) {
id
}
}