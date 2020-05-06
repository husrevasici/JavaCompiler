package JavaCompiler;

interface Command {
	public void checkSyntax(String s) throws Exception;
	public void executeCommand(String s) throws Exception;
}
