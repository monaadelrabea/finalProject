package pojos;
// Generated Jun 2, 2016 7:43:06 PM by Hibernate Tools 4.3.1

import com.google.gson.annotations.Expose;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Projectsforusers generated by hbm2java
 */
@Entity
@Table(name = "projectsforusers", catalog = "itiproject"
)
public class Projectsforusers implements java.io.Serializable {

    @Expose
    private Integer projectId;
    private Category category;
    private Users users;
    @Expose
    private String projectName;
    @Expose
    private String projectDescription;
    @Expose
    private int budget;
    @Expose
    private Date startDate;
    @Expose
    private Date projectDeadLine;
    private Set<Porposa> porposas = new HashSet<Porposa>(0);
    @Expose
    private Set<Projectsimages> projectsimageses = new HashSet<Projectsimages>(0);
    @Expose
    private Set<Postforprojects> postforprojectses = new HashSet<Postforprojects>(0);
    @Expose
    private Set<Skilltable> skilltables = new HashSet<Skilltable>(0);
    @Expose
    private Set<Details> detailses = new HashSet<Details>(0);
    private Set<Tagsofprojects> tagsofprojectses = new HashSet<Tagsofprojects>(0);

    public Projectsforusers() {
    }

    public Projectsforusers(Category category, Users users, String projectName, String projectDescription, int budget) {
        this.category = category;
        this.users = users;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.budget = budget;
    }

    public Projectsforusers(Category category, Users users, String projectName, String projectDescription, int budget, Date startDate, Date projectDeadLine, Set<Porposa> porposas, Set<Projectsimages> projectsimageses, Set<Postforprojects> postforprojectses, Set<Skilltable> skilltables, Set<Details> detailses, Set<Tagsofprojects> tagsofprojectses) {
        this.category = category;
        this.users = users;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.budget = budget;
        this.startDate = startDate;
        this.projectDeadLine = projectDeadLine;
        this.porposas = porposas;
        this.projectsimageses = projectsimageses;
        this.postforprojectses = postforprojectses;
        this.skilltables = skilltables;
        this.detailses = detailses;
        this.tagsofprojectses = tagsofprojectses;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "projectId", unique = true, nullable = false)
    public Integer getProjectId() {
        return this.projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId", nullable = false)
    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ownerIdForProject", nullable = false)
    public Users getUsers() {
        return this.users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Column(name = "projectName", nullable = false)
    public String getProjectName() {
        return this.projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Column(name = "projectDescription", nullable = false)
    public String getProjectDescription() {
        return this.projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    @Column(name = "budget", nullable = false)
    public int getBudget() {
        return this.budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "startDate", length = 10)
    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "projectDeadLine", length = 10)
    public Date getProjectDeadLine() {
        return this.projectDeadLine;
    }

    public void setProjectDeadLine(Date projectDeadLine) {
        this.projectDeadLine = projectDeadLine;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "projectsforusers")
    public Set<Porposa> getPorposas() {
        return this.porposas;
    }

    public void setPorposas(Set<Porposa> porposas) {
        this.porposas = porposas;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "projectsforusers")
    public Set<Projectsimages> getProjectsimageses() {
        return this.projectsimageses;
    }

    public void setProjectsimageses(Set<Projectsimages> projectsimageses) {
        this.projectsimageses = projectsimageses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "projectsforusers")
    public Set<Postforprojects> getPostforprojectses() {
        return this.postforprojectses;
    }

    public void setPostforprojectses(Set<Postforprojects> postforprojectses) {
        this.postforprojectses = postforprojectses;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "skillsforprojects", catalog = "itiproject", joinColumns = {
        @JoinColumn(name = "projectId", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "skillId", nullable = false, updatable = false)})
    public Set<Skilltable> getSkilltables() {
        return this.skilltables;
    }

    public void setSkilltables(Set<Skilltable> skilltables) {
        this.skilltables = skilltables;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "projectsforusers")
    public Set<Details> getDetailses() {
        return this.detailses;
    }

    public void setDetailses(Set<Details> detailses) {
        this.detailses = detailses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "projectsforusers")
    public Set<Tagsofprojects> getTagsofprojectses() {
        return this.tagsofprojectses;
    }

    public void setTagsofprojectses(Set<Tagsofprojects> tagsofprojectses) {
        this.tagsofprojectses = tagsofprojectses;
    }

}
