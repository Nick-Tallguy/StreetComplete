package de.westnordost.streetcomplete.quests.memorial_type

import de.westnordost.streetcomplete.R
import de.westnordost.streetcomplete.data.osm.osmquest.SimpleOverpassQuestType
import de.westnordost.streetcomplete.data.osm.changes.StringMapChangesBuilder
import de.westnordost.streetcomplete.data.osm.mapdata.OverpassMapDataAndGeometryApi

class AddMemorialType(o: OverpassMapDataAndGeometryApi) : SimpleOverpassQuestType<String>(o) {

    override val tagFilters = """
        nodes, ways, relations with 
          historic=memorial
          and (!memorial or memorial=yes)
          and !memorial:type
    """
    override val commitMessage = "Add memorial type"
    override val wikiLink = "Key:memorial"
    override val icon = R.drawable.ic_quest_memorial_type

    override fun getTitle(tags: Map<String, String>) = R.string.quest_memorialType_title

    override fun createForm() = AddMemorialTypeForm()

    override fun applyAnswerTo(answer: String, changes: StringMapChangesBuilder) {
        changes.add("memorial", answer)
    }
}
