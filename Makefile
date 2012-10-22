all: clean
	javac -Xlint:unchecked DirtyWorkflow.java
clean:
	rm -f *.class *~ .*.sw*
git_add:
	git add *.java Makefile doc
commit: git_add
	git commit
push:
	git push

