"use strict";

class Humanoid {
    constructor() {
        this.humanoidType = null;    
    }

    walk() {
        if (this.humanoidType === "Lady with high heels") {
            console.log("TOC! TOC! TOC!");
        } else {
            if (this.humanoidType == "Ninja") {
                console.log("...");
            } else {
                if (this.humanoidType == "Pirate") {
                    console.log("Tap, toc, tap, toc.");
                } else {
                    if (this.humanoidType == "Robot") {
                        console.log("Bzz, bang, bzzz, bang");
                    } else {
                        if (this.humanoidType == "Regular human") {
                            console.log("Tap, tap, tap, tap");
                        }
                    }
                }
            }
        }
    }
}


var humanoid1 = new Humanoid();
humanoid1.humanoidType = "Lady with high heels";
humanoid1.walk();

var humanoid2 = new Humanoid();
humanoid2.humanoidType = "Ninja";
humanoid2.walk();

var humanoid3 = new Humanoid();
humanoid3.humanoidType = "Pirate";
humanoid3.walk();

var humanoid4 = new Humanoid();
humanoid4.humanoidType = "Robot";
humanoid4.walk();

var humanoid5 = new Humanoid();
humanoid5.humanoidType = "Regular human";
humanoid5.walk();
