package io.joaofig.keved.views

import io.kvision.core.Overflow
import io.kvision.html.Div
import io.kvision.panel.Direction
import io.kvision.panel.splitPanel
import io.kvision.panel.vPanel
import io.kvision.utils.perc
import io.kvision.utils.px

class TripView : Div() {

    init {
        padding = 4.px
        height = 100.perc

        add(
            splitPanel(direction = Direction.HORIZONTAL) {
                marginTop = 4.px
                height = 100.perc

                vPanel {
                    overflow = Overflow.AUTO
                    height = 50.perc
                }

                vPanel {
                    marginTop = 4.px
                    overflow = Overflow.AUTO
                    height = 50.perc
                }
            }
        )
    }
}