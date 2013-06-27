DMBuddyBot
==========

An IRC bot designed to assist DMs in the setup and play of Tabletop Games over an IRC Channel.

Current working commands
------------------------

Note: These commands only currently work when sent in the channel DMBUddyBot is in, but do not currently work through private messages to the DMBuddyBot

Roll - rolls a d20 dice for the user. Sends message to channel: "Ok %sender%! The number I rolled for you is %number%!"

Roll a xDy - Rolls the specified dice (y, represents the number of sides) x number of times. Sends two messached to channel: "And your total roll is..." "%Number%"

Roll Honest Character 3d6 - Rolls out the base six stats for a D20 character (Strength, Dexterity, Constitution, Wisdom, Intelligence, and Charisma in that order) using the 3d6 method of rolling 3d6 dice and combining all the values for each stat. Names the character "Spike" and reports each stat one message at a time.

Roll Honest Character 4d6 - Rolls out the base six stats for a D20 character (Strength, Dexterity, Constitution, Wisdom, Intelligence, and Charisma in that order) using the 4d6 method of rolling 4d6 dice and combining all but the lowest value for each stat. Names the character "Timmy" and reports each stat one message at a time.

GTFO - Causes the DMBuddyBot to quit the server entirely, leaving with a grumbling message. NSFW. Primarily used for testing and will be removed once the DMBuddybot is completed
