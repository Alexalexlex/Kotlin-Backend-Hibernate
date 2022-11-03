import javax.persistence.*


@Entity
@Table(name = "STUDENT")
class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: Long? = null

    @Column(name = "STUDENT_NAME", length = 50, nullable = false, unique = false)
    private val name: String? = null // other fields, getters and setters
}