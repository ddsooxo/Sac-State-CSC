# Dechen Chuteng
# GOLD RUSH PROJECT
# CSC 35
# Due - 2019/12/07

.data
Intro:
	.ascii "================================================================\n.*.*.*.*.*.*.C A L I F O R N I A   G O L D   R U S H *.*.*.*.*.*\n================================================================\n\0"
Rules:
	.ascii "\n.*.*.*.*.*  H E R E   A R E   T H E    R U L E S  *.*.*.*.*.*.*.\n================================================================"
	.ascii "\n  1. 20 weeks (5 months)"
	.ascii "\n  2. Your endurance drops 10% - 20% each week. If it reaches 0%, the game ends."
	.ascii "\n  3. Panning for gold yields 0-100 dollars."
	.ascii "\n  4. A sluice yields 0-100 dollars(durability drops 20% - 50% per week)"
	.ascii "\n  5. Food costs 30-50 dollars."
	.ascii "\n  6. Happiness level drops 5% to 15% each week." 
	.ascii "\n  7. Visiting pet cafe can increase hpapiness level between 15% to 40%\n\0"
WeekX:
	.ascii "\n\n  WEEK \0"
WeekLine:
	.ascii "\n - - - - - - - - - - - - - - - - - - - - -\n\0"
CuteLine:
	.ascii " . . . . . . . . . . . . . . . . . . . . . \0"
Money:
	.ascii "\n  You have $\0"
Endurance:
	.ascii "\n  Your endurance level is at \0"
H: 
	.ascii "  Your happiness level is at \0"
VisitPetCafe:
	.ascii "\n  Visiting Pet Cafe costs you flat fee of $20\n\0"
HGained1:
	.ascii "\n  You gained \0"
HGained2:
	.ascii " %  in Happiness! \n\0"
Percentage:
	.ascii " % \n\0"
Sluices:
	.ascii "  Sluice is at \0"
Options:
	.ascii "\n  It's Sunday! Which of the following would you like to do?\n  Please make a selection: "
	.ascii "\n     1. Do nothing "
	.ascii "\n     2. Repair sluice (-$100) "
	.ascii "\n     3. Go to town "
	.ascii "\n     4. Visit Pet Cafe ~~~~!  \n\n\0"
Line: 
	.ascii "\n\0"
WrongOpt:
	.ascii "  Wrong option! Please try again!\0"
NoMoney:
	.ascii "\n  Not enough cash to buy the sluice!\n\n\0"
Pan:
	.ascii "\n  Panning for gold yeilded $\0"
Slu:
	.ascii "\n  The Sluice yielded $\0"
ZeroSluice:
	.ascii "\n  Your sluice is broken. You need to repair it.\n\0"
RepairedS:
	.ascii "\n  You repaired your sluice to \0"
TownCost: 
	.ascii "\n  Going to town costs you $\0"
EnduranceGained:
	.ascii "\n  You regained \0"
EnduranceGained2:
	.ascii " % endurance\n\0"
Food:
	.ascii "\n  You ate $\0"
Food1:
	.ascii " in food.\n\0"	
GameOver: 
	.ascii "\n ================   GAME OVER!   ================\n\0"
Die:
	.ascii "\n THE GAME HAS ENDED. \nYOUR ENDURANCE(THE WILLPOWER TO KEEP GOING) HAS REACHED 0%! \n\0"
EndBalance: 
	.ascii "\n  You ended the game with $\0"
FinalEndurance:
	.ascii "\n  Your endurance was \0"
FinalHappiness:
	.ascii "  Your happiness level was \0"
BearArt:
	.ascii "\n ~*~*~*~* GREETINGS!~*~*~*~* "
	.ascii "\n*         ,-._____,-.       *"
	.ascii "\n*        (_c       c_)      *" 
	.ascii "\n*         /  e-o-e  \\       *"
	.ascii "\n*        (  (._|_,)  )      *"
	.ascii "\n*         >._`---'_,<       *"
	.ascii "\n*       ,'/  `---'  \\`.     *"
	.ascii "\n*     ,' /           \\ `.   *"
	.ascii "\n*    (  (             )  )  *"
	.ascii "\n*     `-'\            /`-'   *"
	.ascii "\n*        |`-._____.-'|      *"
	.ascii "\n*        |     Y     |	    *"
	.ascii "\n*        /     |     \\      *"
	.ascii "\n*       (      |      )     *"
	.ascii "\n*        `-----^-----'      *"
	.ascii "\n* ~*~*~*~* ~*~*~*~* ~*~*~*~**\n\0"

GameOverArt:    
	.ascii "\n          .... NO! ...                  ... MNO! ...       "
	.ascii "\n        ..... MNO!! ...................... MNNOO! ...      "
	.ascii "\n       ..... MMNO! ......................... MNNOO!! .      "
	.ascii "\n    ..... MNOONNOO!   MMMMMMMMMMPPPOII!   MNNO!!!! .       "
	.ascii "\n     ... !O! NNO! MMMMMMMMMMMMMPPPOOOII!! NO! ....        "
	.ascii "\n        ...... ! MMMMMMMMMMMMMPPPPOOOOIII! ! ...          "
	.ascii "\n       ........ MMMMMMMMMMMMPPPPPOOOOOOII!! .....         "
	.ascii "\n       ........ MMMMMOOOOOOPPPPPPPPOOOOMII! ...           "
	.ascii "\n        ....... MMMMM..    OPPMMP    .,OMI! ....          "
	.ascii "\n         ...... MMMM::   o.,OPMP,.o   ::I!! ...           "
	.ascii "\n             .... NNM:::.,,OOPM!P,.::::!! ....            "
	.ascii "\n              .. MMNNNNNOOOOPMO!!IIPPO!!O! .....          "
	.ascii "\n             ... MMMMMNNNNOO:!!:!!IPPPPOO! ....           "
	.ascii "\n               .. MMMMMNNOOMMNNIIIPPPOO!! ......          "
	.ascii "\n              ...... MMMONNMMNNNIIIOO!..........          "
	.ascii "\n           ....... MN MOMMMNNNIIIIIO! OO ..........       "
	.ascii "\n        ......... MNO! IiiiiiiiiiiiI OOOO ...........     "
	.ascii "\n      ...... NNN.MNO! . O!!!!!!!!!O . OONO NO! ........   "
	.ascii "\n       .... MNNNNNO! ...OOOOOOOOOOO .  MMNNON!........    "
	.ascii "\n       ...... MNNNNO! .. PPPPPPPPP .. MMNON!........      "
	.ascii "\n          ...... OO! ................. ON! .......        "
	.ascii "\n              ................................        \n\0"
	
	
.text
.global _start
_start:
	#PRINTS TITLE OF THE GAME	
	mov $0, %rdx
	call SetBackColor
	mov $3, %rdx			
	call SetForeColor
	mov $Intro, %rdx	 
	call PrintCString
	mov $7, %rdx
	call SetForeColor
	
	#PRINTS ASCII ART BEAR
	mov $0, %rdx
	call SetBackColor
	mov $2, %rdx
	call SetForeColor
	mov $BearArt, %rdx
	call PrintCString
	mov $7, %rdx	
	call SetForeColor
	
	#PRINTS RULES
	mov $0, %rdx
	call SetBackColor
	mov $6, %rdx			
	call SetForeColor
	mov $Rules, %rdx
	call PrintCString
	mov $7, %rdx	
	call SetForeColor
		
	#MAIN REGISTERS
	mov $0, %rax			# %RAX = Week Counter [20 weeks]
	mov $100, %r10			# %R10 = Balance Counter [every player starts with $100]
	mov $100, %rbx			# %RBX = Sluice Counter
	mov $100, %r11			# %R11 = Endurance Counter [drops 10 % to 25% each week] 
	mov $100, %r14			# %R14 = Happniness Counter [drops 20 % to 30 % each week]
	
Weeks:
	add $1, %rax		
	cmp $20, %rax		
	jg EndGame	
	
	#IF ENDURANCE LEVEL = 0%, PLAYER DIES 
	cmp $0, %r11			
	je EndGameEarly
	
	#COMPARES ENDURANCE <= 0%, SET IT = 0% UNTIL PLAYER UPS ITS ENDURANCE
	cmp $0, %r11
	jle SetEZero
	jmp WeekLoop
	
	#COMPARES IF ENDURANCE >= 100%, SET IT = 100%	
	cmp $100, %r11
	jge SetE100
	jmp WeekLoop
	
	#COMPARES IF HAPPINESS >= 100%, SET IT = 100%
	cmp $100, %r14
	jge SetH100
	jmp WeekLoop

	#IF HAPINESS REACHES 0%, SET = 0%
        cmp $0, %r14 
        je SetHZero

        cmp $0, %r14
	jg WeekLoop


SetE100:
        mov $100, %r11
SetEZero:
	mov $0, %r11
SetH100:
	mov $100, %r14
SetHZero:
	mov $0, %r14
	
WeekLoop:
	#IF ENDURANCE IS 0%, END GAME
	cmp $0, %r11
	je EndGame
	
	mov $0, %rdx
	call SetBackColor
	mov $2, %rdx			
	call SetForeColor
	mov $WeekX, %rdx	
	call PrintCString
	
	#WEEK NUMBER STORED IN %RAX
	mov %rax, %rdx			
	call PrintInt			
	mov $WeekLine, %rdx	
	call PrintCString
	mov $7, %rdx	
	call SetForeColor
	
  	#---PRINTS THE STATS OF THE PLAYER IN EACH WEEK--- 
	
	#PRINTS PLAYER'S BALANCE
	mov $Money, %rdx	
	call PrintCString 
	mov $1, %rdx			
	call SetForeColor
	mov %r10, %rdx	
	call PrintInt		
	mov $7, %rdx	
	call SetForeColor
	
	#PRINTS ENDURANCE LEVEL
	mov $Endurance, %rdx 	
	call PrintCString
	mov $1, %rdx			
	call SetForeColor
	mov %r11, %rdx
	call PrintInt
	mov $Percentage, %rdx
	call PrintCString
	mov $7, %rdx	
	call SetForeColor

	#PRINTS HAPPINESS LEVEL 
	mov $H, %rdx
	call PrintCString
	mov $1, %rdx
	call SetForeColor
	mov %r14, %rdx
	call PrintInt
	mov $Percentage, %rdx
	call PrintCString
	mov $7, %rdx
	call SetForeColor
	
	#PRINTS SLUICE LEVEL	
	mov $Sluices, %rdx		
	call PrintCString
	mov $1, %rdx			
	call SetForeColor
	mov %rbx, %rdx
	call PrintInt
	mov $Percentage, %rdx
	call PrintCString
	mov $7, %rdx	
	call SetForeColor

	#PRINTS LIST OF OPTIONS FOR PLAYER
	mov $CuteLine, %rdx
	call PrintCString
	
	mov $Options, %rdx
	call PrintCString
	
	call ScanInt
		
	#WHEN USER PICKS OPTION 1
	cmp $1, %rdx
	je doNothing
	
	#WHEN USER PICKS OPTION 2
	cmp $2, %rdx			
	je Repair
	
	#WHEN USER PICKS OPTION 3
	cmp $3, %rdx			
	je CostOfTown
	
	cmp $4, %rdx
	je PetCafe
	
	cmp $5, %rdx
	jge WrongOption
	
	jmp Weeks 
WrongOption: 
	mov $1, %rdx
	call SetBackColor
	mov $3, %rdx			
	call SetForeColor
	
	mov $WrongOpt, %rdx
	call PrintCString
	sub $1, %rax

	mov $7, %rdx	
	call SetForeColor
	
	jmp Weeks
	
#OPTION 1: DO NOTHING
doNothing: 
	mov $Pan, %rdx
    	call PrintCString
	
	#PRINTS RANDOM MONEY AFTER PANNING FOR GOLD
    	mov $100, %rdx       	
    	call Random          	
    	call PrintInt
	
	#ADDING RDX += RCX; RDX BEING THE VALUE ADDED to R10
    	add %rdx, %r10       	

    	mov $Slu, %rdx
    	call PrintCString
	
	#IF SLUICE DURABILITY IS <= TO 0%, JUMP TO NOSLUICENOMONEY LABEL
	cmp $0, %rbx
	jle NoSluiceNoMoney
	
	#PLAYER EARNS RANDOM SLUICE MONEY BETWEEN $0 AND $1000 
    	mov $1001, %rdx
    	call Random
    	call PrintInt

	#ADD RANDOM SLUICE MONEY TO %R10
    	add %rdx, %r10		 	

	mov $Food, %rdx
	call PrintCString
	
	#FOOD COSTS $30 TO $50
	#MOV 21 GIVES YOU RADNOM RANGE FROM 0 TO 20 BUT ADDING 30 GIVES YOU RANGE FROM 30 TO 50
    	mov $21, %rdx        	
    	call Random          	
    	add $30, %rdx        	
    	call PrintInt
	
    	#SUBTRACTS FOOD COST FROM MONEY PLAYER HAS IN %R10    
	sub %rdx, %r10			

    	mov $Food1, %rdx       
    	call PrintCString

    	jmp PowerTracker

#SLUICE AT 0%, DOESN'T PRODUCE ANY PROFITS
NoSluiceNoMoney:
	mov $0, %rbx
	mov %rbx, %rdx
	call PrintInt
	
	mov $0, %rdx
	call SetBackColor
	mov $1, %rdx			
	call SetForeColor
	
	mov $ZeroSluice, %rdx
	call PrintCString
	
	mov $7, %rdx	
	call SetForeColor
	
	jmp PowerTracker

#CHECKS ENDURANCE & SLUICE LEVEL
PowerTracker:
	
	#ENDURANCE LEVEL DROPS BETWEEN 10% TO 25% EACH WEEK   
	mov $15, %rdx			
	call Random		
	add $10, %rdx
	
	#SUBTRACT RANDOM ENDURANCE FROM STARTING ENDURANCE LEVEL WHICH WAS 100% 
	sub %rdx, %r11			 	
	
	#HAPPINESS LEVEL DROPS BETWEEN 5% TO 15% EACH WEEK
        mov $10, %rdx
        call Random
        add $5, %rdx
	
	#SUBTRACT HAPPINESS LEVEL
	sub %rdx, %r14
	
	cmp $0, %r14
	jle SetHZero

	#SLUICE LEVEL DROPS 20% TO 50% EACH WEEK	
	mov $30, %rdx		    
	call Random
	add $20, %rdx

	sub %rdx, %rbx
	
	#IF SLUICE REACHES 0%, SET = 0%
	cmp $0, %rbx			
	jle SetSluZero	
	
	cmp $0, %rbx
	jg Weeks
		
	SetSluZero:
	mov $0, %rbx
	
	jmp Weeks

#OPTION 2: REPAIR SLUICE 
Repair: 
	#JUMP IF PLAYER HAS $100 OR GREATOR TO REPAIR THE SLUICE
	cmp $100, %r10
	jg RepairTrans       	
	
	#JUMP IF PLAYER HAS LESS THAN $100 TO REPAIR THE SLUICE
	cmp $100, %r10
	jl NoFundsToRepairS	

RepairTrans:
    	#SUBTRACTS -$100 FROM %R10 & CHANGES SLUICE LEVEL TO 100%
	sub $100, %r10		 	
	mov $100, %rbx		    
	mov $RepairedS, %rdx	
	call PrintCString
	
	mov %rbx, %rdx
	call PrintInt
	
	mov $Percentage, %rdx
	call PrintCString

	jmp doNothing
	

#LETS PLAYER NO HE/SHE DOES NOT HAVE ENOUGH FUNDS TO REPAIR SLUICE 
NoFundsToRepairS:	
	mov $NoMoney, %rdx
	call PrintCString	 	    

#OPTION 3: GO TO TOWN
CostOfTown:
	mov $TownCost, %rdx	
	call PrintCString
	
	#COST OF TOWN = BETWEEN $50 AND $200
	mov $150, %rdx 
	call Random	
	add $50, %rdx
	call PrintInt
	
	#SUBTRACT COST FROM MONEY PLAYER HAS SO FAR
	sub %rdx, %r10			
	
	#GAIN ENDURANCE LEVEL BETWEEN 5% TO 50% 
	mov $45, %rdx
	call Random			    
	add $5, %rdx
	
	#MOVE ENDURANCE % INTO NEW REGISTER TO TEMP. HOLD THAT VALUE
	#AND ADDING THAT VALUE TO PREVIOUS ENDURANCE LEVEL
	mov %rdx, %r15			
	add %r15, %r11		

	mov $EnduranceGained, %rdx	
	call PrintCString
	
	#PRINTS OUT THAT GAINED ENDURANCE LEVEL WHEN PLAYER VISITS TOWN
	mov %r15, %rdx			
	call PrintInt		
	
	mov $EnduranceGained2, %rdx
	call PrintCString

	jmp doNothing


#OPTION 4: VISIT PET CAFE 
PetCafe:
	mov $0, %rdx
	call SetBackColor
	mov $3, %rdx
	call SetForeColor
	mov $VisitPetCafe, %rdx
	call PrintCString
	
	mov $7, %rdx
	call SetForeColor
	
	sub $20, %r10
	
	#GAIN HAPPINESS LEVEL BETWEEN 15% TO 40%
        mov $25, %rdx
        call Random
        add $15, %rdx

        #MOVE HAPPINESS % INTO NEW REGISTER TO TEMP. HOLD THAT VALUE
        #AND ADDING THAT VALUE TO PREVIOUS HAPPINESS LEVEL
        mov %rdx, %r12
        add %r12, %r14

        mov $HGained1, %rdx
        call PrintCString

        #PRINTS OUT THAT GAINED HAPPINESS LEVEL WHEN PLAYER VISITS PET CAFE
        mov %r14, %rdx
        call PrintInt

        mov $HGained2, %rdx
        call PrintCString

        jmp doNothing


#END GAME FROM HAVING ZERO ENDURANCE 
EndGameEarly:
	mov $0, %r11
	jmp PowerTracker	
	
	#PRINTS DIE MESSAGE FROM HAVING ZERO ENDURANCE
	mov $0, %rdx
	call SetBackColor
	mov $1, %rdx			
	call SetForeColor
	mov $Die, %rdx
	call PrintCString
	mov $7, %rdx	
	call SetForeColor
	
	call End

#END GAME AFTER 20 WEEKS; PRINTS OUT ENDURANCE LEVEL + FINAL BALANCE 
EndGame:
	mov $0, %rdx
	call SetBackColor
	mov $1, %rdx			
	call SetForeColor
	mov $GameOver, %rdx
	call PrintCString
	mov $GameOverArt, %rdx
	call PrintCString
	mov $7, %rdx	
	call SetForeColor

	mov $EndBalance, %rdx
	call PrintCString
	mov %r10, %rdx	
	call PrintInt
	
	mov $FinalEndurance, %rdx
	call PrintCString
	mov %r11, %rdx
	call PrintInt
	mov $Percentage, %rdx
	call PrintCString
	
	mov $FinalHappiness, %rdx
	call PrintCString
	mov %r14, %rdx
	call PrintInt
	mov $Percentage, %rdx
	call PrintCString
	
	jmp End

End:
	call EndProgram
