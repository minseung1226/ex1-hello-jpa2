package hellojpa.domain;

import javax.persistence.*;

@Entity
public class Member extends BaseEntity{

    @Id@GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String name;
/*

    @OneToOne
    @JoinColumn(name = "locker_id")
    private Locker locker;
*/

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
