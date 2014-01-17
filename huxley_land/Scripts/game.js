Game = {
    start: function() {
        WIDTH = 800;
        HEIGHT = 600;
        Crafty.init(WIDTH, HEIGHT);

        Crafty.sprite(480, 270, "assets/fire_circle_sprite.png", {
            FireCircle: [0,0],
        });

        Crafty.sprite(249, 140, "assets/fire_circle_sprite_min.png", { 
            FireCircleMin: [0, 0],
        });

        Crafty.sprite(64, 65, "assets/fone_sprite.png", { 
            Fone: [0, 0],
        });

        Crafty.scene("main", function() {
            Crafty.e("2D, DOM, Image")
               .attr({w: Crafty.viewport.width, h: Crafty.viewport.height})
               .image("assets/Old_map_800.png");

            Crafty.e("2D, DOM, SpriteAnimation, FireCircleMin")
                .reel('PlayerRunning', 1300, 0, 0, 15) // setup animation
                .attr({x:-29, y:305})
                .animate('PlayerRunning', -1);

            Crafty.e("2D, DOM, SpriteAnimation, FireCircle")
                .reel('PlayerRunning', 1300, 0, 0, 15) // setup animation
                .attr({x:65, y:60})
                .animate('PlayerRunning', -1); 
            Crafty.e("2D, DOM, SpriteAnimation, FireCircleMin")
                .reel('PlayerRunning', 1300, 0, 0, 15) // setup animation
                .attr({x:315, y:295})
                .animate('PlayerRunning', -1);

            Crafty.e("2D, DOM, SpriteAnimation, FireCircle")
                .reel('PlayerRunning', 1300, 0, 0, 15) // setup animation
                .attr({x:430, y:250})
                .animate('PlayerRunning', -1);

            Crafty.e("2D, DOM, SpriteAnimation, FireCircleMin")
                .reel('PlayerRunning', 1300, 0, 0, 15) // setup animation
                .attr({x:610, y:30})
                .animate('PlayerRunning', -1);

            Crafty("SpriteAnimation").each(function(e) {
                this.visible = false;
                if(e == 0) {
                    this.visible = true;
                }
                    
            });

            Crafty.e("2D, Sprite, DOM, Fone, Mouse") 
                .attr({x:700, y:480});

        });


        Crafty.load(["assets/fire_circle_sprite.png", "assets/fire_circle_sprite_min.png"], function () {
            // Crafty.audio.setChannels(5);
            // Crafty.audio.play("musica.wav", -1);
            Crafty.scene("main"); //when everything is loaded, run the main scene
        });

    }
}


