var express = require('express');
var mysql = require('mysql');
var bodyParser = require('body-parser');

var con = mysql.createConnection({
host:'localhost',
user: 'root',
password: '',
database: 'art_exhibition'
});

var app=express();
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended:true}));

app.post('/register/',(req,res,next)=>{

	var post_data = req.body;
	var name = post_data.name;
	var phone = post_data.phone;
	var password = post_data.password;
	var email = post_data.email;
	var id = name+phone;
	console.log(name,password,email,phone,id);
	con.query('SELECT * from user where email=?',[email],function(err,result,fields){
		con.on('error',function(err){
			console.log('mysql error',err);
		});
		if(result && result.length)
			res.json('User Already Exist');
		else
		{
			con.query('INSERT INTO `user` (`id`, `password`, `email`, `phone`, `name`) VALUES (?,?,?,?,?)',[id,password,email,phone,name],function(err,result,fields){
				con.on('error',function(err){
					console.log('mysql error',err);
					res.json('Registration error');
				});
				res.json('Registrartion succesful');
			});
		}
	});
});

app.post('/login/',(req,res,next)=>{
	var post_data = req.body;

	var email = post_data.email;
	var password = post_data.password;
	


	con.query('SELECT * FROM user where email = ?',[email],function(err,result,fields){
		con.on('error',function(err){
			console.log('mysql error',err);
		});
		if(result && result.length){
			if(password == result[0].password){
				res.json('Valid user');	
			}else{
				res.json('Invalid user');
			}
		}
	});


});

app.listen(9999,()=>{
console.log('Alkesh Restful running on port 9999');
})