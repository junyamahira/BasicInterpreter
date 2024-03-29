package interpreter.node;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import interpreter.Environment;
import interpreter.LexicalType;
import interpreter.Value;

public class BlockNode extends Node {
	private static final Set<LexicalType> FIRST =
			new HashSet<LexicalType>(Arrays.asList(LexicalType.DO,
					LexicalType.WHILE, LexicalType.IF));

    static boolean isMatch(LexicalType type) {
        return FIRST.contains(type);
    }

    public static Node getHandler(Environment env) throws Exception {
        if (IfBlockNode.isMatch(env.getInput().peep().getType())) {
            return IfBlockNode.getHandler(env);
        } else if (LoopBlockNode.isMatch(env.getInput().peep().getType())) {
            return LoopBlockNode.getHandler(env);
        } else {
            throw new Exception("Block:不適切な型:" + env.getInput().peep().getType());
        }
    }

    @Override
    public boolean parse() throws Exception {
        throw new Exception("Block:parseはNG");
    }

    @Override
    public Value getValue() throws Exception {
        throw new Exception("Block:getValueはNG");
    }

    @Override
    public String toString() {
        return "Block"; //表示されないはず
    }
}
