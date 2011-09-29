/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */
package mage.sets.innistrad;

import java.util.UUID;
import mage.Constants.CardType;
import mage.Constants.Rarity;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.OnEventTriggeredAbility;
import mage.abilities.effects.common.DrawCardTargetEffect;
import mage.abilities.effects.common.LoseLifeTargetEffect;
import mage.abilities.keyword.FlyingAbility;
import mage.cards.CardImpl;
import mage.game.events.GameEvent.EventType;
import mage.target.TargetPlayer;

/**
 *
 * @author North
 */
public class BloodgiftDemon extends CardImpl<BloodgiftDemon> {

    public BloodgiftDemon(UUID ownerId) {
        super(ownerId, 89, "Bloodgift Demon", Rarity.RARE, new CardType[]{CardType.CREATURE}, "{3}{B}{B}");
        this.expansionSetCode = "ISD";
        this.subtype.add("Demon");

        this.color.setBlack(true);
        this.power = new MageInt(5);
        this.toughness = new MageInt(4);

        this.addAbility(FlyingAbility.getInstance());
        // At the beginning of your upkeep, target player draws a card and loses 1 life.
        Ability ability = new OnEventTriggeredAbility(EventType.UPKEEP_STEP_PRE, "beginning of your upkeep", new DrawCardTargetEffect(1), false);
        ability.addEffect(new LoseLifeTargetEffect(1));
        ability.addTarget(new TargetPlayer());
        this.addAbility(ability);
    }

    public BloodgiftDemon(final BloodgiftDemon card) {
        super(card);
    }

    @Override
    public BloodgiftDemon copy() {
        return new BloodgiftDemon(this);
    }
}
