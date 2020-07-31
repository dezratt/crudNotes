# crudNotes
Study sharing application built in Spring, with ThymeLeaf, hibernate, and MySQL

INSTRUCTIONS TO GET WORKING ON LOCAL MACHINE:

1.) you will need the latest version of MySQL
2.) you will need Java13 or higher
3.) create a new schema in MySQL and name it crudnotes
4.) create a user named crudnotes in said schema and grant them all permissions
5.) change the password in the applications.properties file to whatever your MySQL root password is.
6.) at this point the application should be able to boot locally from the gradle/tasks/application/bootrun source

INSTRUCTIONS ON HOW TO USE APP

1.) start by registering a new user and password
2.) next create a new note type.
3.) create a new note.
4.) all functions will now be working in app.


Copyright 2020 David Ezratty

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.


