package Momotaro.Output;

import Momotaro.Battle.*;
import Momotaro.Character.*;
import Momotaro.Dungeon.*;
import Momotaro.Item.*;
import Momotaro.Output.*;
import Momotaro.Party.*;
import Momotaro.Skill.*;

public class MomotaroDeadException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public MomotaroDeadException(String msg) {
        super(msg);
    }

}