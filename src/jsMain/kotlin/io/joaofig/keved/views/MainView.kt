package io.joaofig.keved.views

import io.kvision.html.Div
import io.kvision.panel.splitPanel
import io.kvision.panel.vPanel
import io.kvision.utils.perc
import io.kvision.utils.vh

class MainView : Div() {

    init {
        height = 100.vh
        width = 100.perc

        splitPanel {
            height = 100.perc
            width = 100.perc

            vPanel {

            }

            vPanel {

            }
        }
    }
}