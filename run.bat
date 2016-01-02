@echo off
if not "%CD%" equ "C:\Users\legoc\Desktop\stuff\cpy\java\eclipse\workspace\Youtube Simulator" cd "C:\Users\legoc\Desktop\stuff\cpy\java\eclipse\workspace\Youtube Simulator" 
cd src
javac -cp ../../../lib/jgslick.jar com/mkprog/youtube/*.java
java  -cp ../../../lib/jgslick.jar;./ -Djava.library.path="../../../lib/natives-win" com.mkprog.youtube.YoutubeSimulator