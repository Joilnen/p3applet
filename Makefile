all:
	javac -Xlint:unchecked DirtyWorkflow.java
clean:
	rm -f *.class *~ *.sw*
git_add:
	git add *.java Makefile
commit: git_add
	git commit
push:
	git push

