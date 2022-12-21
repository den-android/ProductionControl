package net.denis.productioncontrol.data.mapper

import net.denis.productioncontrol.data.model.AssemblyStageData
import net.denis.productioncontrol.domain.model.AssemblyStage
import net.denis.productioncontrol.util.Mapper
import javax.inject.Inject

class AssemblyStageDataDomainMapper @Inject constructor(): Mapper<AssemblyStageData, AssemblyStage> {

    override fun from(input: AssemblyStageData?): AssemblyStage {
        return AssemblyStage(
            id = input.id,

        )
    }

    override fun to(output: AssemblyStage): AssemblyStageData {
        TODO("Not yet implemented")
    }

}
