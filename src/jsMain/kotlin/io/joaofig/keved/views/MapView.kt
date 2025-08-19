package io.joaofig.keved.views

import io.kvision.html.Div
import io.kvision.maps.DefaultTileLayers
import io.kvision.maps.Maps
import io.kvision.utils.perc
import kotlinx.coroutines.launch

class MapView: Div() {
    private val map = createMap()

    init {
        add(map)
    }

    private fun createMap(): Maps {
        val map = Maps(
            optionsConfigure = {
                contextmenu = true
                contextmenuItems = arrayOf(
                    io.kvision.utils.obj {
                        text = "Zoom In"
                        icon = "images/png/zoom_in.png"
                        callback = { this@MapView.zoomIn() }
                    },
                    io.kvision.utils.obj {
                        text = "Zoom Out"
                        icon = "images/png/zoom_out.png"
                        callback = { this@MapView.zoomOut() }
                    }
                )
            }
        )

        map.height = 100.perc
        map.width = 100.perc

//        AppScope.launch {
//            val geoBounds = ClusterClient.getClusterBounds()
//            val latLngBounds = geoBounds.toLatLngBounds()
//
//            map.configureLeafletMap {
//                fitBounds(latLngBounds)
//                addLayer(DefaultTileLayers.OpenStreetMap)
//            }
//        }
        return map
    }

    private fun zoomIn() {
        map.leafletMap {
            zoomIn()
        }
    }

    private fun zoomOut() {
        map.leafletMap {
            zoomOut()
        }
    }
}