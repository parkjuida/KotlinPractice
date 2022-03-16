
interface TicketBooker {
    fun book()
    fun isAvailable()
}

class TrainTicketBooker: TicketBooker {
    override fun book() {
        println("Book Train ticket")
    }

    override fun isAvailable() {
        println("Train ticket available")
    }
}

class AirplaneTicketBooker: TicketBooker {
    override fun book() {
        println("Book Airplane ticket")
    }

    override fun isAvailable() {
        println("Airplane ticket available")
    }
}

class TicketBookAgent(private val booker: TicketBooker): TicketBooker {
    override fun book() {
        booker.book()
    }

    override fun isAvailable() {
        booker.isAvailable()
    }
}

val airplaneAgent = TicketBookAgent(AirplaneTicketBooker())
val trainTicketBooker = TicketBookAgent(TrainTicketBooker())

airplaneAgent.book()
trainTicketBooker.book()

class AgentByDelegation(): TicketBooker by AirplaneTicketBooker()
val agent1 = AgentByDelegation()
agent1.book()

class TicketBookAgentUsingDelegation(val booker: TicketBooker): TicketBooker by booker
val agent2 = TicketBookAgentUsingDelegation(AirplaneTicketBooker())

agent2.book()

class SuperTicketBookAgent(): TicketBooker by AirplaneTicketBooker() {
    override fun book() {
        println("Book First class ticket")
    }
}

SuperTicketBookAgent().book()

interface Guide {
    fun connect()
    fun isAvailable()
}

class CastleGuide: Guide {
    override fun connect() {
        println("Castle Guide connected")
    }

    override fun isAvailable() {
        println("Castle Guide available")
    }
}

class TotalTravelAgency(): TicketBooker by AirplaneTicketBooker(), Guide by CastleGuide() {
    override fun isAvailable() {
        println("lets check all available")
    }
}