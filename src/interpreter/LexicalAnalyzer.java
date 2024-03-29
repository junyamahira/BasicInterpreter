package interpreter;

public interface LexicalAnalyzer {
    public LexicalUnit get() throws Exception;
    public boolean expect(LexicalType type) throws Exception;
    public void unget(LexicalUnit token) throws Exception;
    public LexicalUnit peep() throws Exception;
    public LexicalUnit peep(int n) throws Exception;

}
