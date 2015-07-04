<<<<<<< .merge_file_a05692
This is actually a webapp for Spring. Very Important to know Spring
scalable code

I have to develop two roles Admin and User

Admin Add Stocks and Markets

User just show prizes

we are going to add Jquery to the user to show graficas

looks like login is phasesession_listener

We have to implement the different tasks with ant
=======
This is actually a webapp for Spring. Very Important to know Spring
scalable code

I have to develop two roles Admin and User

Admin Add Stocks and Markets

User just show prizes

we are going to add Jquery to the user to show graficas

looks like login is phasesession_listener

We have to implement the different tasks with ant
>>>>>>> .merge_file_a07968


-------------------------  Transactional -----------------------

You can omit the transaction-manager attribute in the <tx:annotation-driven/> tag 
if the bean name of the PlatformTransactionManager that you want to wire in has 
the name transactionManager. If the PlatformTransactionManager bean that you want 
to dependency-inject has any other name, then you have to use the transaction-manager 
attribute explicitly, as in the preceding example.
[Note]
The @EnableTransactionManagement annotation provides equivalent support if you are 
using Java based configuration. Simply add the annotation to a @Configuration class.
 See the javadocs for full details.
