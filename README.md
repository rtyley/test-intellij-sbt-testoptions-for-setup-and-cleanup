# test-intellij-sbt-testoptions-for-setup-and-cleanup

Sbt supports [setup & cleanup actions for tests](https://www.scala-sbt.org/1.x/docs/Testing.html#Setup+and+Cleanup)
using `Tests.Setup` and `Tests.Cleanup` in the `testOptions` setting.

IntelliJ supports [running tests straight from the code editor](https://www.jetbrains.com/help/idea/performing-tests.html),
but currently it won't run the `Tests.Setup` and `Tests.Cleanup` steps - for IntelliJ users this can lead to
intermittent test failures that are surprising to users who aren't aware of both the custom sbt configuration, and
the fact that IntelliJ won't run those test actions (e.g.
[scala-steward #3101](https://github.com/scala-steward-org/scala-steward/pull/3101)).

https://github.com/rtyley/test-intellij-sbt-testoptions-for-setup-and-cleanup/assets/52038/badf7575-34e1-4825-bcbb-48ac5483a344.mov
