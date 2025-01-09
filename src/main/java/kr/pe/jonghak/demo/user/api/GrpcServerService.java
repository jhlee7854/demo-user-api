package kr.pe.jonghak.demo.user.api;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.Optional;

@GrpcService
@Slf4j
public class GrpcServerService extends UserServiceGrpc.UserServiceImplBase {
    private final UserRepository userRepository;

    public GrpcServerService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void getUser(UserRequest request, StreamObserver<UserReply> responseObserver) {
        String name = request.getName();
        log.info("requested user name: {}", name);

        Optional<User> user = userRepository.findOne(Example.of(new User(null, request.getName(),  null)));
        User foundUser = user.orElseThrow();
        UserReply reply = UserReply.newBuilder()
            .setId(foundUser.getId())
            .setName(foundUser.getName())
            .setEmail(foundUser.getEmail())
            .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
