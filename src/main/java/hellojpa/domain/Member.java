package hellojpa.domain;

import javax.persistence.*;

@Entity
public class Member extends BaseEntity{

    @Id@GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String name;

    @OneToOne
    @JoinColumn(name = "locker_id")
    private Locker locker;

    @ManyToOne
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
}
