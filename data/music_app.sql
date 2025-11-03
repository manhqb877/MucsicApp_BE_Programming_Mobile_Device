-- ⚙️ Đảm bảo cột roles.name là VARCHAR
ALTER TABLE roles MODIFY COLUMN name VARCHAR(50);

-- PERMISSIONS
INSERT INTO permissions (id, name, description) VALUES
                                                    (1, 'READ', 'Quyền đọc dữ liệu'),
                                                    (2, 'WRITE', 'Quyền ghi dữ liệu');

-- ROLES
INSERT INTO roles (id, name, description) VALUES
                                              (1, 'ADMIN', 'Quản trị hệ thống'),
                                              (2, 'CUSTOMER', 'Người dùng thông thường'),
                                              (3, 'ARTIST', 'Người nghệ sĩ');

-- ROLE - PERMISSION
INSERT INTO role_permissions (role_id, permission_id) VALUES
                                                          (1, 1), (1, 2),
                                                          (2, 1);

-- USERS
INSERT INTO users (user_id, username, email, password, created_at, gender)
VALUES
    ('u1', 'admin', 'admin@musicapp.com', '123456', NOW(), 'MALE'),
    ('u2', 'manh', 'manh@gmail.com', '123456', NOW(), 'MALE'),
    ('u3', 'minh', 'minh@gmail.com', '123456', NOW(), 'FEMALE');

-- USER - ROLE
INSERT INTO user_roles (user_id, role_id) VALUES
                                              ('u1', 1),
                                              ('u2', 2),
                                              ('u3', 3);

-- ARTISTS
INSERT INTO artists (artist_id, artist_name, country, bio)
VALUES
    ('a1', 'Taylor Swift', 'USA', 'Famous American singer-songwriter'),
    ('a2', 'Sơn Tùng M-TP', 'Vietnam', 'Vietnamese pop artist');

-- ALBUMS
INSERT INTO albums (album_id, title, release_date, artist_id)
VALUES
    ('al1', '1989', '2014-10-27 00:00:00', 'a1'),
    ('al2', 'Lạc Trôi EP', '2017-01-01 00:00:00', 'a2');

-- SONGS
INSERT INTO songs (song_id, song_title, duration, album_id)
VALUES
    ('s1', 'Blank Space', '3:51', 'al1'),
    ('s2', 'Lạc Trôi', '4:05', 'al2');

-- PLAYLISTS
INSERT INTO playlists (playlist_id, name, description, user_id)
VALUES
    ('p1', 'My Favorites', 'Best songs ever', '3599c7c0-6c8e-499a-80e7-b4f29f6b5edc');

-- PLAYLIST_SONG
INSERT INTO playlist_song (id, playlist_id, song_id, date_add)
VALUES
    (1, 'p1', 's1', NOW()),
    (2, 'p1', 's2', NOW());

-- COMMENTS
INSERT INTO comments (comment_id, text, user_id)
VALUES
    ('c1', 'Tuyệt vời quá!', '3599c7c0-6c8e-499a-80e7-b4f29f6b5edc'),
    ('c2', 'I love this song!', '83f8493c-b763-4f11-bc0e-1c1cc8ec1873');
