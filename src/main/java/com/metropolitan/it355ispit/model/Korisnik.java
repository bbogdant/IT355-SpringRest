package com.metropolitan.it355ispit.model;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "korisnik")
public class Korisnik implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "IME", nullable = false, length = 20)
    private String ime;

    @Column(name = "PREZIME", nullable = false, length = 20)
    private String prezime;

    @Column(name = "DATUM_RODJENJA", nullable = false)
    private LocalDate datumRodjenja;

    @Column(name = "ADRESA", nullable = false, length = 50)
    private String adresa;

//    @Column(name = "TIP_KORISNIKA", nullable = false)
//    @JoinColumn(name = "TIP_KORISNIKA", nullable = false)
//
//    private TipKorisnika tipKorisnika;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "TIP_KORISNIKA", nullable = false)
    private Rola rola;

    @Column(name = "USERNAME", nullable = false, length = 25)
    private String username;

    @Column(name = "LOZINKA")
    private String lozinka;

    @OneToMany(mappedBy = "korisnikFk")
    private Set<Ocena> ocenas = new LinkedHashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return lozinka;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}