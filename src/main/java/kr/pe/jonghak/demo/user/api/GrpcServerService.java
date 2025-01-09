package kr.pe.jonghak.demo.user.api;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@Slf4j
public class GrpcServerService extends UserServiceGrpc.UserServiceImplBase {

    @Override
    public void getUser(UserRequest request, StreamObserver<UserReply> responseObserver) {
        String name = request.getName();
        log.info("requested user name: {}", name);

        // TODO: mongoDB에서 사용자를 조회한 후 해당 사용자 정보를 응답 정보로 사용한다.
        UserReply reply = UserReply.newBuilder()
            .setId("testId")
            .setName(name)
            .setEmail("testEmail")
            .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
